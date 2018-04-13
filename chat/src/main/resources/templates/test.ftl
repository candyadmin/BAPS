<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>FreeMarker Index</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
</head>

<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/index">Project name</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <form class="navbar-form navbar-right">
                <div class="form-group">
                    <input type="text" placeholder="Email" class="form-control">
                </div>
                <div class="form-group">
                    <input type="password" placeholder="Password" class="form-control">
                </div>
                <button type="submit" class="btn btn-success">Sign in</button>
            </form>
        </div><!--/.navbar-collapse -->
    </div>
</nav>

<div class="jumbotron">
    <div class="container">
        <h1>Hello, world!</h1>
        <p>This is a template for a simple marketing or informational website. It includes a large callout called a
            jumbotron and three supporting pieces of content. Use it as a starting point to create something more
            unique.</p>
        <p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more &raquo;</a></p>
    </div>
</div>

<div class="container">
    <div class="row">
        <table class="table table-striped table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>name</th>
                <th>sunmary</th>
            </tr>
            </thead>
            <tbody>
       	 	  	  <#list userInfos as userInfo>
                  <tr>
                      <td>
                          ${userInfo.id}
                      </td>
                      <td>

                        <#if userInfo.name?length &gt; 2>
                            ${userInfo.name?substring(0,2)} ...
                        <#else>
                            ${userInfo.name}
                        </#if>

                      </td>
                      <td>${userInfo.tel}</td>
                      <td>${userInfo.create_time}</td>
                  <#--<#switch userInfo.status>-->
                  <#--<#case "1">-->
                  <#--发布-->
                  <#--<#break>-->
                  <#--<#default>-->
                  <#--草稿-->
                  <#--</#switch>-->
                  <#--</td>-->
                  <#--<td>-->
                  <#--${userInfo.createTime?date}-->
                  <#--</td>-->
                  </tr>
                  </#list>
            </tbody>
            <tfoot>
            <tr>
            <#--<td colspan="6" class="text-center">-->
            <#--<ul class="pagination" style="margin:0px;">-->
            <#--<!-- First Page &ndash;&gt;-->
            <#--<#if page.isFirstPage()>-->
            <#--<li><span aria-hidden="true">&laquo;</span></li>-->
            <#--<#else>-->
            <#--<li>-->
            <#--<a href="/index?page=${page.pageNumber-1}" aria-label="Previous">-->
            <#--<span aria-hidden="true">&laquo;</span>-->
            <#--</a>-->
            <#--</li>-->
            <#--</#if>-->

            <#--<#list page.navigatePageNumbers as index>-->
            <#--<li><a href="/index?page=${index}">${index}</a></li>-->
            <#--</#list>-->

            <#--<!-- Last Page &ndash;&gt;-->
            <#--<#if page.isLastPage()>-->
            <#--<li><span aria-hidden="true">&raquo;</span></li>-->
            <#--<#else>-->
            <#--<li>-->
            <#--<a href="/index?page=${page.pageNumber+1}" aria-label="Previous">-->
            <#--<span aria-hidden="true">&raquo;</span>-->
            <#--</a>-->
            <#--</li>-->
            <#--</#if>-->
            <#--</ul>-->
            <#--</td>-->
            </tr>
            </tfoot>
        </table>
    </div>
	  <#include "footer.ftl">
</div> <!-- /container -->
<script>
    alert('${jsValue}');
'<#list userInfos as userInfo>'
    console.log('${userInfo.id}');
'</#list>'

</script>



</body>
</html>