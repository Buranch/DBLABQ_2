/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package products;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Biruk
 */
public class ListBridge {
    
    
    
    Map<String, Integer> data = new HashMap<String, Integer>();
    String view;
    javax.swing.JList jList;
    javax.swing.JTable jTable;
    
    public ListBridge(Map<String, Integer> data, String view, javax.swing.JList jList, javax.swing.JTable jTable ) {
        this.data = data;
        this.jList = jList;
        this.jTable = jTable;
        this.view = view;
        
        this.setModal();
    }
    
    
    public Map getData() {
        return this.data;
    }
    
   
    public void sort() {
        this.sortByalphabet(this.data);
        this.setModal();
    }
    
    
    public <K extends Comparable,V extends Comparable> Map<K,V> sortByalphabet(Map<K,V> map){
        List<K> keys = new LinkedList<K>(map.keySet());
        Collections.sort(keys);
      
        //LinkedHashMap will keep the keys in the order they are inserted
        //which is currently sorted on natural ordering
        Map<K,V> sortedMap = new LinkedHashMap<K,V>();
        for(K key: keys){
            sortedMap.put(key, map.get(key));
        }
      
        this.data = (Map<String, Integer>) sortedMap;
        return sortedMap;
    }
    
    public void setModal() {
        if(this.view == "Excutive") {
            Object[][] tdata = new Object[this.data.size()][2];
            Iterator it = this.data.entrySet().iterator();
            int i = 0;
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                System.out.println(pair.getKey() + "    ------------     " + pair.getValue());
                tdata[i][0] = pair.getKey();
                tdata[i][1] = pair.getValue();
                i++;
            }
            
            this.jTable.setModel(new CustModel(tdata));
        }
        else{
            DefaultListModel listModel = new DefaultListModel();
            Iterator it = this.data.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                System.out.println(pair.getKey() + "    ------------     " + pair.getValue());
                listModel.addElement(pair.getKey());
            }
            this.jList.setModel(listModel);
        }
    }
    
}
