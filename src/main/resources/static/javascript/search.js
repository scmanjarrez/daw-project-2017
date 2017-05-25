/**
 * Created by S on 25/05/2017.
 */
$('.modal').each(function(){
    var src = $(this).find('iframe').attr('src');
    $(this).on('click', function(){
        $(this).find('iframe').attr('src', '');
        $(this).find('iframe').attr('src', src);
    });
});