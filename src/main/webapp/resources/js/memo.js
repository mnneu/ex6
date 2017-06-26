/**
 * 
 */
function memoWrite(writer,contents){
		$.ajax({
			url:"memoWrite",
			type:"post",
			data:{
				writer:writer,
				contents:contents				
			},
			success:function(data){
				var result = "<table>";
				$(data).each(function(){
					result = result+"<tr>";
					result = result+"<td>"+this.num+"</td>";
					result = result+"<td>"+this.contents+"</td>";
					result = result+"<td>"+this.writer+"</td>";
					result = result+"<td>"+this.reg_date+"</td>";
					result = result+"</tr>";
				});
				result = result+"</table>";
				$("#result").html(result);
			}
		});
	}

	function memoView(){
		$("#viewbtn").click(function(){
			
			
		});
		
	}
	
	function getList(curPage, find, search){
	 	/*$.get("URL?name=value",function(data){});
		$.post("UdRL",{name:value},function(ata){});		
		$.ajax({url:,datatype:get/post,	data:{},success:function(data){	}	});
		$("#result").load */
		$.ajax({
			url:"getMemoList/"+curPage+"/"+find+"/"+search,
			type:"GET",
			data:{	},
			success:function(data){									
				var result = "<table>";
				$(data).each(function(){
					result = result+"<tr>";
					result = result+"<td>"+this.num+"</td>";
					result = result+"<td>"+this.contents+"</td>";
					result = result+"<td>"+this.writer+"</td>";
					result = result+"<td>"+this.reg_date+"</td>";
					result = result+"</tr>";
				});
				result = result+"</table>";
				$("#result").html(result);
				
			}
		});
		
	}