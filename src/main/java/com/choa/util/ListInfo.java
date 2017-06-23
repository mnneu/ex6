package com.choa.util;

public class ListInfo {

	private Integer curPage;
	private Integer perPage;
	
	
	private int curBlock;
	private int totalBlock;
	private int startNum;
	private int lastNum;
	
	//row
	private String search;
	private String find;	
	private int startRow;
	private int lastRow;
	
	
	public void makePage(int totalCount){
		//1. totalPage
		int totalPage = 0;
		int perBlock=5;
		if(totalCount%this.getPerPage() ==0){
			totalPage = totalCount/this.getPerPage();
		}else{
			totalPage = totalCount/this.getPerPage()+1;
		}
		//2. totalBlock
		if(totalPage%perBlock==0){
			totalBlock = totalPage/perBlock;
		}else{
			totalBlock = totalPage/perBlock+1;
		}
		//3. curBlock
		if(this.getCurPage()%perBlock==0){
			curBlock = this.getCurPage()/perBlock;
			
		}else{
			curBlock = this.getCurPage()/perBlock+1;
		}
		//4. startNum, lastNum
		startNum = (curBlock-1)*perBlock+1;
		lastNum = curBlock*perBlock;
		
		if(curBlock==totalBlock){
			lastNum = totalPage;
		}
	}
	
	//makeRow
		public void setRow(){
			startRow = this.getPerPage()*(this.getCurPage()-1)+1;
			lastRow = this.getPerPage()*this.getCurPage();
		}	
	
	
	
	public int getCurBlock() {
		return curBlock;
	}



	public int getTotalBlock() {
		return totalBlock;
	}



	public int getStartNum() {
		return startNum;
	}



	public int getLastNum() {
		return lastNum;
	}



	
	
	
	
	public int getStartRow() {
		return startRow;
	}
	
	public int getLastRow() {
		return lastRow;
	}
	
	
	public Integer getPerPage() {
		if(perPage == null){
			perPage = 10;
		}
		return perPage;
	}
	public void setPerPage(Integer perPage) {
		this.perPage = perPage;
	}
	public Integer getCurPage() {
		if(curPage == null){
			curPage = 1;
		}
		return curPage;
	}
	public void setCurPage(Integer curPage) {
		
		this.curPage = curPage;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getFind() {
		return find;
	}
	public void setFind(String find) {
		this.find = find;
	}
	
	
}
