/*
 * Copyright 2010 Brian Pellin.
 *     
 * This file is part of KeePassDroid.
 *
 *  KeePassDroid is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  KeePassDroid is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with KeePassDroid.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package com.keepassdroid.database.edit;

import com.keepassdroid.Database;
import com.keepassdroid.database.PwDatabase;
import com.keepassdroid.database.PwEntry;
import com.keepassdroid.database.PwGroupV3;

public class AddEntryV3 extends AddEntry {
	
	private PwEntry mEntry;
	
	protected AddEntryV3(Database db, PwEntry entry, OnFinish finish) {
		super(db, entry, finish);
		
		mEntry = entry;
	}
	
	
	public void addEntry() {
		PwGroupV3 parent = (PwGroupV3) mEntry.getParent();
		
		// Add entry to group
		parent.childEntries.add(mEntry);
		
		// Add entry to PwDatabaseV3
		PwDatabase pm = (PwDatabase) mDb.pm;
		pm.getEntries().add(mEntry);
		
		// Sort entries
		parent.sortEntriesByName();
		
	}

}