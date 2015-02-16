var converter = new Showdown.converter();

var samplereports = [
    {
        title: "Hi there!",
        name: "Just sample post",
        version: "0.1",
        template: "",
        defaultJsonData: ""
    }
]

var myRactive = new HATEOASRactive({
    el: '#reports',
    template: '#reports-template',
    data: {rows : samplereports, renderMarkdown: function (md) { return converter.makeHtml(md); }}
});


$(document).ready(function(){
    $('#reports-template').hide();
    myRactive.restURL = '/rest/reports?page=0&size=10';
    myRactive.modelListName = 'reports';
    myRactive.fire( 'init' );

    ckeditor = $('#template').ckeditor();

    $('#previewBtn').click(function(){
        var data = $('#defaultJsonData').val();
        var template = $('#template').val();

        if(data && template) {
            var id = 'rows';

            var $html = $('<div/>', {html: template});
            $html.find('table').each(function(){
                var t = $(this);
                var id = t.attr('id');
                if(id) {
                    $html.find('table#' + id + ' > tbody > tr').not(':first').not(':last').before('{{#' + id + '}}').after('{{/' + id + '}}');
                }
            });
            template = $html.html();

            data = $.parseJSON(data);
            var ractive = new Ractive({
                el: 'previewBody',
                template: template, //'#template',
                data: data
            });
        } else {
            $('#previewBody').html('Please select report');
        }

    });

function CKupdate(){
    for ( instance in CKEDITOR.instances ) {
        CKEDITOR.instances[instance].updateElement();
        CKEDITOR.instances[instance].setData('');
    }
}

    $('#submitBtn').click(function(){
        $('#template').val(ckeditor.val());
        myRactive.data.template = ckeditor.val();
        CKupdate()
    });
});
