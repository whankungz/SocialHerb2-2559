/**
 This program is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 2 of the License, or
 (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>.

 **/

/**
 This file is part of Save For Offline, an Android app which saves / downloads complete webpages for offine reading.
 **/

/**
 If you modify, redistribute, or write something based on this or parts of it, you MUST,
 I repeat, you MUST comply with the GPLv2+ license. This means that if you use or modify
 my code, you MUST release the source code of your modified version, if / when this is
 required under the terms of the license.

 If you cannot / do not want to do this, DO NOT USE MY CODE. Thanks.

 (I've added this message to to the source because it's been used in severeral proprietary
 closed source apps, which I don't want, and which is also a violation of the liense.)
 **/

/**
 Written by Jonas Czech (JonasCz, stackoverflow.com/users/4428462/JonasCz and github.com/JonasCz). (4428462jonascz/eafc4d1afq)
 **/

package jonas.tool.saveForOffline;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.ActionMode;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends Activity implements SearchView.OnQueryTextListener {


	private DisplayAdapter gridAdapter;
	private jonas.tool.saveForOffline.Database mHelper;
	private SQLiteDatabase dataBase;

	private TextView noSavedPages;
	private TextView helpText;
	
	private DisplayAdapter.SortOrder sortOrder = DisplayAdapter.SortOrder.NEWEST_FIRST;
	

	private GridView mainGrid;
	private SearchView mSearchView;
	private String searchQuery = "";
	private ProgressDialog pageLoadDialog;
	private AlertDialog dialogSortItemsBy;
	private ActionBar actionbar;

	private int scrollPosition;
	private boolean defaultHtmlViewer;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
		SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
		
		if (sharedPref.getBoolean("dark_mode", false)) {
			setTheme(android.R.style.Theme_Holo);
		}
		defaultHtmlViewer = sharedPref.getBoolean("default_htmlviewer", false);

		setContentView(R.layout.main);
		
		mainGrid = (GridView) findViewById(R.id.List);

		mainGrid.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);

		mainGrid.setMultiChoiceModeListener(new ModeCallback());

		int list_layout_type = Integer.parseInt(sharedPref.getString("layout" , "1"));
		switch (list_layout_type) {
			case 1: break;
			case 2: mainGrid.setNumColumns(-1); break;
			case 4: mainGrid.setNumColumns(1); break;
			case 5: mainGrid.setNumColumns(1); break;
			case 6: mainGrid.setNumColumns(1); break;
			default:
		}
		
		sortOrder = sortOrder.fromInt(sharedPref.getInt("current_sort_order", 0));

		pageLoadDialog = new ProgressDialog(jonas.tool.saveForOffline.MainActivity.this);
		actionbar = getActionBar();

		setUpGridClickListener();

		noSavedPages = (TextView) findViewById(R.id.textNoSavedPages);
		helpText = (TextView) findViewById(R.id.how_to_text);

		gridAdapter = new DisplayAdapter(jonas.tool.saveForOffline.MainActivity.this);

		mainGrid.setAdapter(gridAdapter);


	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == 1 && resultCode == RESULT_FIRST_USER) {
			recreate();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu items for use in the action bar
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main_activity_actions, menu);
		MenuItem searchItem = menu.findItem(R.id.action_search);
        mSearchView = (SearchView) searchItem.getActionView();
		mSearchView.setIconifiedByDefault(true);
		mSearchView.setOnQueryTextListener(this);
		mSearchView.setOnSearchClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					onQueryTextChange(mSearchView.getQuery().toString());
				}
		});
		return super.onCreateOptionsMenu(menu);
	}


	public boolean onQueryTextChange(String newText) {
		searchQuery = newText;
		displayData(newText);
		if (newText.length() == 0) {
			actionbar.setSubtitle(R.string.action_bar_subtitle_showing_all);
		} else { 
			if (gridAdapter.getCount() == 1) {actionbar.setSubtitle(R.string.one_search_result);} else if (gridAdapter.getCount() == 0) {actionbar.setSubtitle(R.string.no_search_results);} else {actionbar.setSubtitle(gridAdapter.getCount() + " " + getResources().getString(R.string.num_search_results));}
		}
        return false;
    }

    public boolean onQueryTextSubmit(String query) {
		displayData(query);
        return false;
    }

    public boolean onClose() {
        displayData("");
        return false;
    }

	@Override
	protected void onPause() {
		super.onPause();
		scrollPosition = mainGrid.getFirstVisiblePosition();
	}



	@Override
	protected void onResume() {
		super.onResume();

		pageLoadDialog.cancel();
		displayData(searchQuery);
		mainGrid.setSelection(scrollPosition);
		if (searchQuery.length() == 0) {
			actionbar.setSubtitle(R.string.action_bar_subtitle_showing_all);
		}

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle presses on the action bar items
		switch (item.getItemId()) {
			case R.id.action_add:
				Intent i = new Intent(getApplicationContext(), AddActivity.class);
				startActivity(i);
				return true;
				
				case R.id.action_sort_by:
				AlertDialog.Builder builder = new AlertDialog.Builder(jonas.tool.saveForOffline.MainActivity.this);
				builder.setSingleChoiceItems(R.array.sort_by, DisplayAdapter.SortOrder.toInt(sortOrder), new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							sortOrder = DisplayAdapter.SortOrder.fromInt(which);
							
							SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(jonas.tool.saveForOffline.MainActivity.this).edit();
							editor.putInt("current_sort_order", which);
							editor.commit();
							
							displayData(searchQuery);
							dialogSortItemsBy.cancel();
						}
					});
				dialogSortItemsBy = builder.create();
				dialogSortItemsBy.show();

				return true;

			case R.id.ic_action_settings:
				Intent settings = new Intent(this, Preferences.class);
				startActivityForResult(settings, 1);

				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}

	private void setUpGridClickListener() {
		//click to show saved page
		mainGrid.setOnItemClickListener(new OnItemClickListener() {

				public void onItemClick(AdapterView<?> arg0, View clickedView, int position,
										long id) {

					clickedView.setBackgroundColor(Color.parseColor("#FFC107"));

					pageLoadDialog.setMessage("Please wait while loading...");
					pageLoadDialog.setIndeterminate(true);
					pageLoadDialog.setCancelable(false);

					pageLoadDialog.show();
                    String filepath = gridAdapter.getPropertiesByPosition(position, jonas.tool.saveForOffline.Database.FILE_LOCATION);

					if (defaultHtmlViewer) {

						startDefaultHtmlViewer(filepath);

					} else {
						try {
							Intent i = new Intent(getApplicationContext(),
									ViewActivity.class);
							i.putExtra(jonas.tool.saveForOffline.Database.ORIGINAL_URL, gridAdapter.getPropertiesByPosition(position, jonas.tool.saveForOffline.Database.ORIGINAL_URL));
							i.putExtra(jonas.tool.saveForOffline.Database.TITLE, gridAdapter.getPropertiesByPosition(position, jonas.tool.saveForOffline.Database.TITLE));
							i.putExtra(jonas.tool.saveForOffline.Database.ID, gridAdapter.getPropertiesByPosition(position, jonas.tool.saveForOffline.Database.ID));
							i.putExtra(jonas.tool.saveForOffline.Database.FILE_LOCATION, filepath);
							i.putExtra(jonas.tool.saveForOffline.Database.THUMBNAIL, gridAdapter.getPropertiesByPosition(position, jonas.tool.saveForOffline.Database.THUMBNAIL));
							i.putExtra(jonas.tool.saveForOffline.Database.TIMESTAMP, gridAdapter.getPropertiesByPosition(position, jonas.tool.saveForOffline.Database.TIMESTAMP));

							startActivity(i);
						} catch (Exception e){
							pageLoadDialog.cancel();
							Toast.makeText(jonas.tool.saveForOffline.MainActivity.this, "No application to open  file", Toast.LENGTH_SHORT).show();
						}
					}
				}
			});
	}

    private void startDefaultHtmlViewer(String filepath) {
		pageLoadDialog.cancel();

		final File file = new File(filepath);
		MimeTypeMap myMime = MimeTypeMap.getSingleton();
		String mimeType = myMime.getMimeTypeFromExtension(getFileExtension(filepath).substring(1));

		Intent i = new Intent();
		i.setAction(android.content.Intent.ACTION_VIEW);
		i.setDataAndType(Uri.fromFile(file), mimeType);

		try {
			startActivity(i);
		} catch (Exception e) {
			Toast.makeText(jonas.tool.saveForOffline.MainActivity.this, "No application to open  file", Toast.LENGTH_SHORT).show();
		}
	}

    private String getFileExtension(String filepath) {

        final File file = new File(filepath);
        String filename = file.getName().toString();

        String ext = null;

        try {
            ext = filename.substring(filename.lastIndexOf("."),
                    filename.length());

        } catch (IndexOutOfBoundsException e) {

            ext = "";

        }
        return ext;
    }
	private void displayData(String searchQuery) {

		gridAdapter.refreshData(searchQuery, sortOrder, true);

		if (gridAdapter.getCount() == 0 && !searchQuery.equals("")) {
			noSavedPages.setText("No search results");
			noSavedPages.setVisibility(View.VISIBLE);
			noSavedPages.setGravity(Gravity.CENTER_HORIZONTAL);
			mainGrid.setVisibility(View.GONE);
		} else if (gridAdapter.getCount() == 0) {
			noSavedPages.setText("No saved pages");
			noSavedPages.setVisibility(View.VISIBLE);
			helpText.setVisibility(View.VISIBLE);
			mainGrid.setVisibility(View.GONE);
		} else {
			helpText.setVisibility(View.GONE);
			noSavedPages.setVisibility(View.GONE);
			mainGrid.setVisibility(View.VISIBLE);
		}



	}


	class ModeCallback implements ListView.MultiChoiceModeListener	{

		private EditText e ;
		@Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {

            getMenuInflater().inflate(R.menu.main_activity_multi_choice, menu);
            mode.setTitle("Select Items");

            return true;
        }



		@Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
			gridAdapter.selectedViewsPositions.clear();
            return true;
        }

		@Override
        public boolean onActionItemClicked(final ActionMode mode, MenuItem item) {

			switch (item.getItemId()) {
				case R.id.action_rename:
					AlertDialog.Builder rename_dialog = new AlertDialog.Builder(jonas.tool.saveForOffline.MainActivity.this);
					View layout = getLayoutInflater().inflate(R.layout.rename_dialog, null);
					rename_dialog.setView(layout);
					e = (EditText) layout.findViewById(R.id.rename_dialog_edit);
					TextView t = (TextView) layout.findViewById(R.id.rename_dialog_text);
					if (gridAdapter.selectedViewsPositions.size() == 1) {
						e.setText(gridAdapter.getPropertiesByPosition(gridAdapter.selectedViewsPositions.get(0), jonas.tool.saveForOffline.Database.TITLE));
						e.selectAll();
					
					} else {
						
						t.setText("Enter new title for these " + gridAdapter.selectedViewsPositions.size() + " saved pages :");
					}
					
					
					rename_dialog.setPositiveButton("Rename",
						new DialogInterface.OnClickListener() {

							public void onClick(DialogInterface dialog, int which) {
								mHelper = new jonas.tool.saveForOffline.Database(jonas.tool.saveForOffline.MainActivity.this);
								dataBase = mHelper.getWritableDatabase();

								for (Integer position: gridAdapter.selectedViewsPositions) {
									ContentValues values=new ContentValues();
									values.put(jonas.tool.saveForOffline.Database.TITLE, e.getText().toString() );
									dataBase.update(jonas.tool.saveForOffline.Database.TABLE_NAME, values, jonas.tool.saveForOffline.Database.ID + "=" + gridAdapter.getPropertiesByPosition(position, jonas.tool.saveForOffline.Database.ID), null);
								}
								
								if (gridAdapter.selectedViewsPositions.size() == 1) {
									Toast.makeText(jonas.tool.saveForOffline.MainActivity.this, "Saved page renamed", Toast.LENGTH_LONG).show();
								} else {
									Toast.makeText(jonas.tool.saveForOffline.MainActivity.this, "Renamed " + gridAdapter.selectedViewsPositions.size() + " saved pages", Toast.LENGTH_LONG).show();
								}

								dataBase.close();
								displayData("");
								mode.finish();
							}
						});
						
					rename_dialog.setNegativeButton("Cancel",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int which) {
								mode.finish();
							}
						});
					AlertDialog rename_dialog_alert = rename_dialog.create();
					rename_dialog_alert.show();
				return true;
				case R.id.action_delete:



					AlertDialog.Builder build;
					build = new AlertDialog.Builder(jonas.tool.saveForOffline.MainActivity.this);
					if (gridAdapter.selectedViewsPositions.size() == 1) {
						build.setMessage("Do you want to delete ?\r\n" + gridAdapter.getPropertiesByPosition(gridAdapter.selectedViewsPositions.get(0), jonas.tool.saveForOffline.Database.TITLE));
					} else {
						build.setMessage("Delete these " + gridAdapter.selectedViewsPositions.size() + " saved pages ?");
					}
					build.setPositiveButton("Delete",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int which) {
								new deleteItemsTask().execute(gridAdapter.selectedViewsPositions.toArray());
								mode.finish();	
							}
						});

					build.setNegativeButton("Cancel",
						new DialogInterface.OnClickListener() {

							public void onClick(DialogInterface dialog, int which) {
								dialog.cancel();
								mode.finish();
							}
						});
					AlertDialog alert = build.create();
					alert.show();
					break;
				default:
					break;
            }
			return true;
		}
		
		private class deleteItemsTask extends AsyncTask<Object, Integer, Integer> {
			ProgressDialog pd = null;
			int currentProgress = 0;
			
			@Override
			protected Integer doInBackground(Object[] selectedPositions) {
				dataBase = new jonas.tool.saveForOffline.Database(jonas.tool.saveForOffline.MainActivity.this).getWritableDatabase();
				
				for (final Object position : selectedPositions) {
					String fileLocation = gridAdapter.getPropertiesByPosition((Integer) position, jonas.tool.saveForOffline.Database.FILE_LOCATION);
					DirectoryHelper.deleteDirectory(new File(fileLocation).getParentFile());
					
					dataBase.delete(jonas.tool.saveForOffline.Database.TABLE_NAME, jonas.tool.saveForOffline.Database.ID + "=" + gridAdapter.getPropertiesByPosition((Integer)position, jonas.tool.saveForOffline.Database.ID), null);
					currentProgress++;
					publishProgress(currentProgress);
				}
				dataBase.close();
				return selectedPositions.length;
			}

			@Override
			protected void onPreExecute() {
				pd = new ProgressDialog(jonas.tool.saveForOffline.MainActivity.this);
				pd.setMessage("Deleting items...");
				pd.setIndeterminate(false);
				pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
				pd.setMax(gridAdapter.selectedViewsPositions.size());
				pd.setCancelable(false);
				pd.setCanceledOnTouchOutside(false);

				pd.show();
			}

			@Override
			protected void onPostExecute(Integer result) {
				pd.hide();
				pd.cancel();	
				displayData("");
				Toast.makeText(jonas.tool.saveForOffline.MainActivity.this, "Deleted " + result + " saved pages", Toast.LENGTH_LONG).show();
			}

			@Override
			protected void onProgressUpdate(Integer[] values) {
				pd.setProgress(values[0]);
			}
			
		}

		@Override
        public void onDestroyActionMode(ActionMode mode) {
			gridAdapter.selectedViewsPositions.clear();
        }

		@Override
        public void onItemCheckedStateChanged(ActionMode mode,
											  int position, long itemId, boolean checked) {
			Integer pos = position;
			View gridCellLayout = mainGrid.getChildAt(position - mainGrid.getFirstVisiblePosition()).findViewById(R.id.gridCellLayout);
			if (checked) {
				gridAdapter.selectedViewsPositions.add(pos);
				gridCellLayout.setBackgroundColor(Color.parseColor("#FFC107"));
			} else {
				gridAdapter.selectedViewsPositions.remove(pos);
				gridCellLayout.setBackgroundColor(Color.parseColor("#E2E2E2"));
			}

			final int checkedCount = gridAdapter.selectedViewsPositions.size();

            switch (checkedCount) {
                case 0:
                    mode.setSubtitle("Tap to select items");
					findViewById(R.id.action_delete).setEnabled(false);
                    break;
                case 1:
                    mode.setSubtitle("One item selected");
					findViewById(R.id.action_delete).setEnabled(true);
                    break;
                default:
                    mode.setSubtitle(checkedCount + " items selected");
					findViewById(R.id.action_delete).setEnabled(true);
                    break;
            }
        }

	}



}
