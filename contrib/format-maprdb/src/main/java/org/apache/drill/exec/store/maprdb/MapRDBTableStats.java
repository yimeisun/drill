/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.drill.exec.store.maprdb;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.HBaseConfiguration;

import com.mapr.fs.hbase.HBaseAdminImpl;
import org.apache.hadoop.hbase.client.mapr.BaseTableMappingRules;
import org.apache.hadoop.hbase.client.mapr.TableMappingRulesFactory;

public class MapRDBTableStats {
	
	private int numRows;
  private Configuration config = HBaseConfiguration.create();

	public MapRDBTableStats(HTable table) throws Exception {
		HBaseAdminImpl admin = new HBaseAdminImpl(config, TableMappingRulesFactory.create(config));
		numRows = admin.getNumRows(new String(table.getTableName()));
	}

  public MapRDBTableStats(String tableName) throws Exception {
    HBaseAdminImpl admin = new HBaseAdminImpl(config, TableMappingRulesFactory.create(config));
    numRows = admin.getNumRows(tableName);
  }

	public int getNumRows() {
		return numRows;
	}
	
}
