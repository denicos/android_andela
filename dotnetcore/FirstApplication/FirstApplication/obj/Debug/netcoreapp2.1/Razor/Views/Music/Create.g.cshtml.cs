#pragma checksum "F:\gitrepository\android_andela\dotnetcore\FirstApplication\FirstApplication\Views\Music\Create.cshtml" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "ca798fc5f2d018ef3bfdb8fbac24cf0a7cda22dd"
// <auto-generated/>
#pragma warning disable 1591
[assembly: global::Microsoft.AspNetCore.Razor.Hosting.RazorCompiledItemAttribute(typeof(AspNetCore.Views_Music_Create), @"mvc.1.0.view", @"/Views/Music/Create.cshtml")]
[assembly:global::Microsoft.AspNetCore.Mvc.Razor.Compilation.RazorViewAttribute(@"/Views/Music/Create.cshtml", typeof(AspNetCore.Views_Music_Create))]
namespace AspNetCore
{
    #line hidden
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Threading.Tasks;
    using Microsoft.AspNetCore.Mvc;
    using Microsoft.AspNetCore.Mvc.Rendering;
    using Microsoft.AspNetCore.Mvc.ViewFeatures;
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"ca798fc5f2d018ef3bfdb8fbac24cf0a7cda22dd", @"/Views/Music/Create.cshtml")]
    public class Views_Music_Create : global::Microsoft.AspNetCore.Mvc.Razor.RazorPage<FirstApplication.Models.Band>
    {
        #pragma warning disable 1998
        public async override global::System.Threading.Tasks.Task ExecuteAsync()
        {
            BeginContext(37, 2, true);
            WriteLiteral("\r\n");
            EndContext();
#line 3 "F:\gitrepository\android_andela\dotnetcore\FirstApplication\FirstApplication\Views\Music\Create.cshtml"
  
    ViewData["Title"] = "Create";
    Layout = "~/Views/Shared/_Layout.cshtml";

#line default
#line hidden
            BeginContext(128, 1544, true);
            WriteLiteral(@"
<h2>Create</h2>

<h4>Band</h4>
<hr />
<div class=""row"">
    <div class=""col-md-4"">
        <form asp-action=""Create"">
            <div asp-validation-summary=""ModelOnly"" class=""text-danger""></div>
            <div class=""form-group"">
                <label asp-for=""Title"" class=""control-label""></label>
                <input asp-for=""Title"" class=""form-control"" />
                <span asp-validation-for=""Title"" class=""text-danger""></span>
            </div>
            <div class=""form-group"">
                <label asp-for=""Genre"" class=""control-label""></label>
                <input asp-for=""Genre"" class=""form-control"" />
                <span asp-validation-for=""Genre"" class=""text-danger""></span>
            </div>
            <div class=""form-group"">
                <label asp-for=""Origin"" class=""control-label""></label>
                <input asp-for=""Origin"" class=""form-control"" />
                <span asp-validation-for=""Origin"" class=""text-danger""></span>
            </div>
 ");
            WriteLiteral(@"           <div class=""form-group"">
                <label asp-for=""Biography"" class=""control-label""></label>
                <input asp-for=""Biography"" class=""form-control"" />
                <span asp-validation-for=""Biography"" class=""text-danger""></span>
            </div>
            <div class=""form-group"">
                <input type=""submit"" value=""Create"" class=""btn btn-default"" />
            </div>
        </form>
    </div>
</div>

<div>
    <a asp-action=""Index"">Back to List</a>
</div>

");
            EndContext();
        }
        #pragma warning restore 1998
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.ViewFeatures.IModelExpressionProvider ModelExpressionProvider { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.IUrlHelper Url { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.IViewComponentHelper Component { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.Rendering.IJsonHelper Json { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.Rendering.IHtmlHelper<FirstApplication.Models.Band> Html { get; private set; }
    }
}
#pragma warning restore 1591