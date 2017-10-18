package com.cqut.tool.treeNode;

import java.util.ArrayList;
import java.util.List;

public class NodeList {
	List<Node> list = new ArrayList<Node>();
	private boolean createID;
	
	
	
	public List<Node> getNodes(){
		return list;
	}
	
	public void addNode(Node node){
		if(createID)
			node.setId(getNextID());
		
		this.list.add(node);
	}
	
	private String  getNextID(){
		if(list.size() > 9){
			return "0" + String.valueOf(list.size() + 1);
		} else {
			return String.valueOf(list.size() + 1);
		}
	}

	@Override
	public String toString() {
		String result = "";
		for(Node node : list) {
			//result += ( node.getId() +  "\t" + node.getText() +  "\t" +node.getNodeCode() + "\n"  );
		}
		return result;
	}

	public void setCreateID(boolean createID) {
		this.createID = createID;
	}
}
