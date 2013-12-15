package main;

import java.awt.Color;
import menusystem2.*;

public class MakeMenu
{
	public static Menu makeMenu(Menu menu)
	{
		menu.setColor(Color.darkGray);
		menu.setColsRows(3, 1);
		
		menu.setPadding(0, 0);
		
		Menu sidebar = new Menu(0, 0, 1, 1, true);
		sidebar.setColsRows(4, 8);
		menu.addMenu(sidebar);
		
		Button cleanButton = new Button(0, 0, 4, 2, true, "Button 1");
		sidebar.addMenu(cleanButton);
		
		Button scanButton = new Button(0, 2, 4, 1, true, "Button 2");
		sidebar.addMenu(scanButton);
		
		Button clearHistoryButton = new Button(0, 3, 4, 1, true, "Button 3");
		sidebar.addMenu(clearHistoryButton);
		
		Scroller folderScroller = new Scroller(0, 4, 4, 2, true);
		folderScroller.setVisibleRows(3);
		folderScroller.setColsRows(8, 6);
		sidebar.addMenu(folderScroller);
		folderScroller.fillMenu();
		
		Scroller listsScroller = new Scroller(0, 6, 4, 2, true);
		listsScroller.setVisibleRows(3);
		listsScroller.setColsRows(2, 6);
		sidebar.addMenu(listsScroller);
		listsScroller.fillMenu();
		
		sidebar.fillMenu();
		
		Menu matchbar = new Menu(1, 0, 2, 1, true);
		matchbar.setColsRows(10, 10);
		menu.addMenu(matchbar);
		
		Loader loadingbar = new Loader(0, 9, 10, 1, true);
		loadingbar.fgcolor = new Color(6, 176, 37);
		loadingbar.bgcolor = new Color(150, 150, 150);
		matchbar.addMenu(loadingbar);
		
		matchbar.fillMenu();
		
		return menu;
	}
	
	public static Menu makeTestMenu(Menu menu)
	{
		menu.setColsRows(10, 6);
		menu.setColor(Color.darkGray);
		
//		blue loader
		Loader loader = new Loader(0, 1, 6, 1, true);
		loader.fgcolor = new Color(2, 105, 171);
		loader.bgcolor = new Color(13, 40, 83);
		menu.addMenu(loader);
		
		Scroller scroller = new Scroller(0, 2, 2, 3, true);
		scroller.setVisibleRows(3);
		scroller.setColsRows(1, 10);
		menu.addMenu(scroller);
		scroller.fillMenu();
		
////		green loader
//		Loader loader2 = new Loader(1, 0, 4, 1, true);
//		loader2.fgcolor = new Color(6, 176, 37);
//		loader2.bgcolor = new Color(230, 230, 230);
//		menu.addMenu(loader2);
		
		Button b1 = new Button(4, 2, 3, 1, true, "This is a test button");
		menu.addMenu(b1);
		Button b2 = new Button(4, 3, 2, 1, true, "Test button");
		menu.addMenu(b2);
		Button b3 = new Button(4, 4, 2, 1, true, "Test button");
		menu.addMenu(b3);
		Button b4 = new Button(6, 3, 1, 2, true, "Test");
		menu.addMenu(b4);
		
		menu.fillMenu();
		
		return menu;
	}
}
