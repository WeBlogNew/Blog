(function($){
    $.fn.extend({
        "paginate":function(){
            var $this=this;
            //定义分页结构体
            var pageInfo={
                url:$(this).attr("url"),
                currentPage : $(this).attr("currentPage")*1, // 当前页码
                pageCount : $(this).attr("pageCount")*1 // 总页码

            };

            if(pageInfo.pageCount<2)
                return false;
            //初始起始页数、结束页数
            var start=0,end=10;
            if(pageInfo.currentPage>=10)
                start=pageInfo.currentPage-5;

            if(pageInfo.pageCount>pageInfo.currentPage+5)
                end=pageInfo.currentPage+5;
            else
                end=pageInfo.pageCount;
            var html=[];
            // html.push("<ul>");
            if(pageInfo.currentPage!=1)
            //如果不是第一页则有前一页
                html.push("<li class='page_prev'><a href='javascript:void(0)'>&laquo;</a></li>");
            if(pageInfo.pageCount>10&&pageInfo.currentPage>9)
                html.push("<li class='normal'><a href='javascript:void(0)'>1</a></li>");
            for(var i=start;i<end;i++){
                if((i+1)==pageInfo.currentPage)
                    html.push("<li class='active'><a href='javascript:void(0)'>"+(i+1)+"</a></li>");
                else
                    html.push("<li class='normal'><a href='javascript:void(0)'>"+(i+1)+"</a></li>");
            }

            if(pageInfo.pageCount>10&&pageInfo.currentPage<pageInfo.pageCount-4)
                html.push("<li class='normal'><a href='javascript:void(0)'>"+pageInfo.pageCount+"</a></li>");
            if(pageInfo.currentPage!=pageInfo.pageCount)
                html.push("<li class='page_next'><a href='javascript:void(0)'>&raquo;</a></li>");
            // html.push("</ul>");



            $this.html(html.join(""));
            //绑定数据处理函数
            $this.find(".normal a").bind("click",function(){
                redirectTo($(this).html());
            });
            $this.find(".page_prev a").bind("click",function(){
                redirectTo(pageInfo.currentPage-1);
            });
            $this.find(".page_next a").bind("click",function(){
                redirectTo(pageInfo.currentPage+1);
            });

            function redirectTo(page){

                var url=pageInfo.url;
                if(url.indexOf("?")==-1)
                    url+="?";
                else
                    url+="&";
                url+="pageNo="+page;
                window.location.href=url;
            }
            return $this;
        }
    });

})(jQuery);