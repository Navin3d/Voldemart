        var btn=document.getElementById("menu")
        var hum=document.getElementById("alt")
        var path=document.querySelectorAll(".card")
        var cat=document.querySelector("#cat")
        var align=document.querySelector("#cards")
        //search bar
        var card1=document.querySelector("#c1")
        var card2=document.querySelector("#c2")
        var card3=document.querySelector("#c3")
        var card4=document.querySelector("#c4")
        var card5=document.querySelector("#c5")
        var card6=document.querySelector("#c6")
        var card7=document.querySelector("#c7")
        var card8=document.querySelector("#c8")
        var card9=document.querySelector("#c9")
        var searchr=document.querySelector("#sea")
        var searchn=document.querySelector(".psea")
        var body=document.getElementsByTagName("body")
        //changes
        //hamburger
        btn.addEventListener('click',function(e){
            if(hum.classList.contains('hide')){
                hum.classList.add('show')
                hum.classList.remove('hide')
            }
            else{
                hum.classList.add('hide')
                hum.classList.remove('show')
            }
        })
        //hamburger menu
        //path
        var path={c1:"COMPUTERS_AND_ACCESSORIES","c2":"amakart.html/BEST_OFFERS_WITH_MAJOR_DISCOUNTS","c3":"amakart.html/GREAT_OFFERS_ON_FUNITURES",
        "c4":"amakart.html/MENS_FOOTWEAR","c5":"amakart.html/MASALAS_BOTH_INDUSTRY_AND_HOME_MADE",
        "c6":"amakart.html/TOP_PICKS_ON_MENS_CLOTHING",
        "c7":"amakart.html/BEAUTY_AND_TOYS","c8":"amakart.html/MOBILES_AND_GADGETS","c9":"amakart.html/HOUSE_HOLD_APPLIANCES"}
        align.addEventListener('click',doSomething)
        function doSomething(e){
            if(e.target!=e.currentTarget){
                var target=e.target.id
                console.log(target)
                console.log(path[target])
                location.href=path[target]
            }
        }
        // path changes in url

        //rating
        var rate1=document.getElementsByClassName("r1")
        var rate2=document.getElementsByClassName("r2")
        var rate3=document.getElementsByClassName("r3")
        var rate4=document.getElementsByClassName("r4")
        var rate5=document.getElementsByClassName("r5")
        console.log(rate1.length)
        console.log(rate1)
        console.log(document.cookie)
        
       
        //search bar modification
        var data={"COMPUTERS_AND_ACCESSORIES":card1,"BEST_OFFERS_WITH_MAJOR_DISCOUNTS":card2,"GREAT_OFFERS_ON_FURNITURES":card3,
        "MENS_FOOTWEAR":card4,"Masalas_Both_Industry_And_Home_made":card5,"TOP_PICKS_ON_MENS_CLOTHING":card6,
        "BEAUTY_AND_TOYS":card7,"MOBILES_AND_GADGETS":card8,"HOUSE_HOLD_APPLIANCES":card9}
        let test = (notes, text="") => ( 
            notes.filter(note => { 
            let inc = note.toLowerCase().includes(text.toLowerCase());
            
            return inc; 
        }) 
    ); 
    function searchBar(e){
        //When a letter typed All cards disables
        card1.style.display="none"
        card2.style.display="none"
        card3.style.display="none"
        card4.style.display="none"
        card5.style.display="none"
        card6.style.display="none"
        card7.style.display="none"
        card8.style.display="none"
        card9.style.display="none"
        choice=e.target.value
        var value=test(Object.keys(data),choice)
        console.log(value)
        console.log(data[value[0]])
        //this for is to enable the matching card
        for(var i=0;i<value.length;i++){
            data[value[i]].style.display="block"
        }
        //this does action even for the invalid user input in search bar
        if(value.length==0){
            card1.style.display="inline"
            card2.style.display="inline"
            card3.style.display="inline"
            card4.style.display="inline"
            card5.style.display="inline"
            card6.style.display="inline"
            card7.style.display="inline"
            card8.style.display="inline"
            card9.style.display="inline"
        }
    }
    searchr.addEventListener('keyup', searchBar)
    searchn.addEventListener('keyup', searchBar)
    //dropdown menu in Username
    var usernameclick=document.querySelector(".status")
    var userdropdown=document.querySelector(".dropdown-menu")
    usernameclick.addEventListener("click", function(){
        if(userdropdown.classList.contains('hide')){
            userdropdown.classList.add('show')
            userdropdown.classList.remove('hide')
        }
        else{
            userdropdown.classList.add('hide')
            userdropdown.classList.remove('show')
        }
    })

    