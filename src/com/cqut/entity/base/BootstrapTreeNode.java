package com.cqut.entity.base;

import java.util.ArrayList;
import java.util.List;

/**
 * 类详细描述:树节点
 * @ClassName Node
 * @author wangzhijun
 * @date 2016-1-11 下午1:48:54
 */ 
public class BootstrapTreeNode {
	private String id;  //节点ID
	private String text; //节点文本
	private String state; //节点初始状态
	private String level0; //节点等级
	private boolean checked;//指示一个节点是否处于checked状态，用一个checkbox图标表示。
	private String icon;  //节点图标
	private String parent;
	
	private boolean expanded = false;// Boolean，默认值false 	指示一个节点是否处于展开状态。
    private List<BootstrapTreeNode> nodes ;
	private String color; //节点的前景色
	private String backColor ; //节点的背景色
	private String href;  //地址
	
    public BootstrapTreeNode(String id, String text, Object state,
			String level0, boolean checked, Object icon, boolean expanded,
			List<BootstrapTreeNode> nodes, Object color, Object backColor,
			Object href) {
		super();
		this.id = id;
		this.text = text;
		this.level0 = level0;
		this.checked = checked;
		this.expanded = expanded;
	
		setState(state);
		setIcon(icon);
	    setNodes(nodes);
		setColor(color);
		setBackColor(backColor);
		setHref(href);
		
	
	}
    public BootstrapTreeNode() {
    	
    }
	
	public BootstrapTreeNode(String id, String text) {
		super();
			
		this.id = id;
		this.text = text;
	
	}


	public BootstrapTreeNode(String id, String text, String icon) {
		super();
		this.id = id;
		this.text = text;
		this.icon = icon;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}

	public String getParent() {
		return parent;
	}


	public void setParent(String parent) {
		this.parent = parent;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public String getState() {
		return state;
	}


	public void setState(Object state) {
		if(state == null || state.equals(""))
		     this.state = "";
		else this.state = state.toString();
	}


	public String getlevel0() {
		return level0;
	}


	public void setlevel0(String level0) {
		this.level0 = level0;
	}


	public boolean isChecked() {
		return checked;
	}


	public void setChecked(Integer checked) {
		if(checked == null  || checked == 0)
			this.checked = false;
		else
		  this.checked = true;
	}


	public String getIcon() {
		setChecked(12);
		return icon;
	}


	public void setIcon(Object icon) {
		if(icon == null || icon.equals(""))
			  this.icon = "";
			else this.icon = icon.toString();
	}


	public boolean isExpanded() {
		return expanded;
	}


	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}


	public List<BootstrapTreeNode> getNodes() {
		return nodes;
	}


	public void setNodes(List<BootstrapTreeNode> nodes) {
		if(nodes == null || nodes.size() == 0)
			   ;
			else this.nodes = nodes;
	}
	public void addChilred(BootstrapTreeNode node) {
		if(nodes == null )
			nodes = new ArrayList<BootstrapTreeNode>();
		nodes.add(node);
	}


	public String getColor() {
		return color;
	}


	public void setColor(Object color) {
		if(color == null || color.equals(""))
			this.color = "";
		else this.color = color.toString();
	}


	public String getBackColor() {
		return backColor;
	}


	public void setBackColor(Object backColor) {
		if(backColor == null || backColor.equals(""))
			this.backColor = "";
		else this.backColor = backColor.toString();
	}


	public String getHref() {
		return href;
	}


	public void setHref(Object href) {
		if(href == null || href.equals(""))
			this.href = "";
		else this.href = href.toString();
	}


	@Override
	public String toString() {
	        return "BootstrapTreeNode [id=" + id + ", text=" + text + ", state=" + state + ", level0=" + level0 + ", checked=" + checked + ", icon=" + icon
	              +"  , expaned="+expanded +" ,nodes="+nodes.toArray().toString()+"  ,color="+color+"  ,backColor="+backColor+
	        		"  href=" + href + " ]";
	     
	}


}


