package Dominion;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

import Persistence.CrudDAO;
import Persistence.TagDAO;

public class Tag {
	
	private int idTag;
	private String issue;
	
	
	public Tag(String issue) throws SQLException{
		this.issue=issue;
		CrudDAO<Tag> c = new TagDAO();
		Tag t = c.read(this);
		this.idTag=t.getIdTag();
	}
	
	public Tag(){
		
	}
	
	public int getIdTag() {
		return idTag;
	}

	public void setIdTag(int idTag) {
		this.idTag = idTag;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}
	
	@Override
	public String toString() {
		return "Tag [idTag=" + idTag + ", issue=" + issue + "]\n";
	}
	
	public ArrayList<String> getTags() throws SQLException{
		
		ArrayList<String> al_tags = new ArrayList<String>();
		CrudDAO <Tag> crud_t = new TagDAO();
		LinkedList<Tag> ll_tag = crud_t.readAll(new Tag());
		for(int i = 0; i<ll_tag.size(); i++){
			al_tags.add(ll_tag.get(i).getIssue());
		}
		return al_tags;
	}
}