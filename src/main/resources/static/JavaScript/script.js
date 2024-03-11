console.log("Hello World")

const toggleSidebar =  () =>{

    if($(".sidebar").is(":visible")){

        $(".sidebar").css("display","none");
        $(".content").css("margin-left","0%");


    }else{
        $(".sidebar").css("display","block");
        $(".content").css("margin-left","20%");
    }
};
// Hide the sidebar by default
// $(document).ready(function() {
//     $(".sidebar").hide();
// });
