/*!
    * Start Bootstrap - Freelancer v6.0.0 (https://startbootstrap.com/themes/freelancer)
    * Copyright 2013-2020 Start Bootstrap
    * Licensed under MIT (https://github.com/BlackrockDigital/startbootstrap-freelancer/blob/master/LICENSE)
    */
    (function($) {
    "use strict"; // Start of use strict
  
    // Smooth scrolling using jQuery easing
    $('a.js-scroll-trigger[href*="#"]:not([href="#"])').click(function() {
      if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') && location.hostname == this.hostname) {
        var target = $(this.hash);
        target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');
        if (target.length) {
          $('html, body').animate({
            scrollTop: (target.offset().top - 71)
          }, 1000, "easeInOutExpo");
          return false;
        }
      }
    });
  
    // Scroll to top button appear
    $(document).scroll(function() {
      var scrollDistance = $(this).scrollTop();
      if (scrollDistance > 100) {
        $('.scroll-to-top').fadeIn();
      } else {
        $('.scroll-to-top').fadeOut();
      }
    });
  
    // Closes responsive menu when a scroll trigger link is clicked
    $('.js-scroll-trigger').click(function() {
      $('.navbar-collapse').collapse('hide');
    });
  
    // Activate scrollspy to add active class to navbar items on scroll
    $('body').scrollspy({
      target: '#mainNav',
      offset: 80
    });
  
    // Collapse Navbar
    var navbarCollapse = function() {
      if ($("#mainNav").offset().top > 100) {
        $("#mainNav").addClass("navbar-shrink");
      } else {
        $("#mainNav").removeClass("navbar-shrink");
      }
    };
    // Collapse now if page is not at top
    navbarCollapse();
    // Collapse the navbar when page is scrolled
    $(window).scroll(navbarCollapse);
  
    // Floating label headings for the contact form
    $(function() {
      $("body").on("input propertychange", ".floating-label-form-group", function(e) {
        $(this).toggleClass("floating-label-form-group-with-value", !!$(e.target).val());
      }).on("focus", ".floating-label-form-group", function() {
        $(this).addClass("floating-label-form-group-with-focus");
      }).on("blur", ".floating-label-form-group", function() {
        $(this).removeClass("floating-label-form-group-with-focus");
      });
    });
  
  })(jQuery); // End of use strict


function openCatTab(evt, productCategory) {
  var i, tabcontent, tablinks;
  tabcontent = document.getElementsByClassName("tabcontent");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablinks");
  for (i = 0; i < tablinks.length; i++) {
    tablinks[i].className = tablinks[i].className.replace(" active", "");
  }
  document.getElementById(productCategory).style.display = "block";
  evt.currentTarget.className += " active";
}

document.getElementById("defaultOpen").click();   

// tab 링크 안의 제품 리스트
function cpuList () {
  
}

function recommendToWishlist() {
  // 테이블에 있는 제품 데이터(객체)
  // for (i = 0; i< recProduct.length; i++) {
  // recProduct = document.getElementByClassName("recProduct");
  // document.getElementByClassName("wishList") = recProduct;
  
}
 
// 위시리스트에 추가 삭제 버튼
function addWishlist() {
  
}

function removeWishlist() {

}

function list(cat) {
  const xhttp = new XMLHttpRequest();
			xhttp.onload = function() {
				
				let data = this.responseText;
				data = JSON.parse(data);
				
				let tableElement =`
				<table border="1">
				<tr><th>이미지</th><th>제품명</th><th>가격</th></tr>`;
				
				for (let i in data){
					tableElement = tableElement + `<tr>
				 		<td>${data[i].imageUrl}</a></td>
				 		<td>${data[i].name}</td>
				 		<td>${data[i].price}</td>
				    </tr>`;
				}
				tableElement = tableElement + `</table>`;
				document.getElementById(cat).innerHTML = tableElement;
			};
			xhttp.open( "GET", "search/categoryAll?cat=" + cat);
			xhttp.send();

}

async function post(host, path, body, headers = {}) {
  const url = `https://${host}/${path}`;
  const options = {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
      ...headers,
    },
    body: JSON.stringify(body),
  };
  const res = await fetch(url, options);
  const data = await res.json();
  if (res.ok) {
    return data;
  } else {
    throw Error(data);
  }
}
 
function fetchCat(cat) {
  return fetch(`https://jsonplaceholder.typicode.com/posts/${postId}`)
    .then((response) => response.json())
    .then((post) => post.userId)
    .then((userId) => {
      return fetch(`https://jsonplaceholder.typicode.com/users/${userId}`)
        .then((response) => response.json())
        .then((user) => user.name);
    });
}

//fetchAuthorName(1).then((name) => console.log("name:", name));

function allProduct(){
  const xhttp = new XMLHttpRequest();
  xhttp.onload = function() {
    let data = this.responseText;
    data = JSON.parse(data);
    
    let tableElement =`
      <table border="1">
      <tr>   
        <th>이미지</th>
        <th>이름</th>
        <th>가격 id</th>
      </tr>`;
    
    for (let i in data){
      tableElement = tableElement + `<tr>
         <td>${data[i].imageUrl}</td>
         <td>${data[i].name}</td>
         <td>${data[i].price}</td>
        </tr>`;
    }
    
    tableElement = tableElement + `</table>`;
    document.getElementById("all").innerHTML = tableElement;
  };
  xhttp.open( "GET", "search/productAll");
  xhttp.send();
}
