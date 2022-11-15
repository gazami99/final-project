/*!
    * Start Bootstrap - Freelancer v6.0.0 (https://startbootstrap.com/themes/freelancer)
    * Copyright 2013-2020 Start Bootstrap
    * Licensed under MIT (https://github.com/BlackrockDigital/startbootstrap-freelancer/blob/master/LICENSE)
    */
const buttons = document.querySelector(".buttons");

const numOfContent = 178;
const maxContent = 8;
const maxButton = 5;
const maxPage = Math.ceil(numOfContent / maxContent);
let page ;
let cate ;


function makeButton(id) {
  const button = document.createElement("button");
  button.classList.add("button");
  button.dataset.num = id;
  button.innerText = id;
  button.addEventListener("click", (e) => {
    Array.prototype.forEach.call(buttons.children, (button) => {
      if (button.dataset.num) button.classList.remove("active");
    });
    e.target.classList.add("active");
    openCatTab(e,cate);
      if (cate === 'all' ) {
        allProduct(button.dataset.num-1);
      }
      else{
        list(cate,button.dataset.num-1); // from index 0 
      }
  });
  return button;
};


function renderButton(page) {
  // 버튼 리스트 초기화
  

  while (buttons.hasChildNodes()) {
    buttons.removeChild(buttons.lastChild);
  }
  // 화면에 최대 5개의 페이지 버튼 생성
  for (let id = page; id < page + maxButton && id <= maxPage; id++) {
    buttons.appendChild(makeButton(id));
  }
  // 첫 버튼 활성화(class="active")
  buttons.children[0].classList.add("active");
  buttons.children[0].click();

  let prev = document.createElement("button");
  prev.classList.add("button", "prev");
  prev.innerHTML = '<ion-icon name="chevron-back-outline"></ion-icon>';
  prev.addEventListener("click", goPrevPage);

  let next = document.createElement("button");
  next.classList.add("button", "next");
  next.innerHTML = '<ion-icon name="chevron-forward-outline"></ion-icon>';
  next.addEventListener("click", goNextPage);


  buttons.prepend(prev);
  buttons.append(next);

  // 이전, 다음 페이지 버튼이 필요한지 체크
  if (page - maxButton < 1) buttons.removeChild(prev);
  if (page + maxButton > maxPage) buttons.removeChild(next);
};

function render(pages,category) {

  if (category !== cate) {page = 1;}
  cate = category;
  renderButton(pages);
  
};

function goPrevPage() {
  page -= maxButton;
  render(page,cate);
};

function goNextPage() {
  page += maxButton;
  render(page,cate);
};



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

function allProduct(pagenum){
  const xhttp = new XMLHttpRequest();
  xhttp.onload = function() {
    let data = this.responseText;
    data = JSON.parse(data);
    
    let tableElement =`
    <div class="row">
    `;
    
    for (let i in data){
      tableElement = tableElement + `
      <div class="col-lg-3 col-md-4 ">
       <div class="card">
            <a class="text-dark">
            
            <img src="${data[i].imageUrl}" class="card-img-top" object-fit:cover;>
            <div class="card-body">
            <span class="card-title" >${data[i].name}</span>
            <h5 class="card-title text-danger">${data[i].price}</h5>
            <button style="all: unset; background-color: steelblue; color: white; padding: 5px, 20px, border-radius: 5px; cursor: pointer;" id="open">상세보기</button>
            

            
            </div> </a></div></div>`;
          }
          tableElement = tableElement + `</div>`;
    document.getElementById("all").innerHTML = tableElement;
  };
  xhttp.open( "GET", "search/all/"+pagenum+"/8");
  xhttp.send();
}


function list(cat,pagenum) {
  const xhttp = new XMLHttpRequest();
			xhttp.onload = function() {
				
				let data = this.responseText;
				data = JSON.parse(data);
				
				let tableElement =`
        <div class="row">
        `;
        
        for (let i in data){
          tableElement = tableElement + `
          <div class="col-lg-3 col-md-4 ">
           <div class="card">
                <a class="text-dark">
                
                <img src="${data[i].imageUrl}" class="card-img-top" object-fit:cover;>
                <div class="card-body">
                <span class="card-title" >${data[i].name}</span>
                <h5 class="card-title text-danger">${data[i].price}</h5>
                <button style="all: unset; background-color: steelblue; color: white; padding: 5px, 20px, border-radius: 5px; cursor: pointer;" id="open">상세보기</button>
                
    
                
                </div> </a></div></div>`;
              }
              tableElement = tableElement + `</div>`;
				document.getElementById(cat).innerHTML = tableElement;
			};
			xhttp.open( "GET", "search/categoryAll/"+pagenum+"/8?cat=" + cat);
			xhttp.send();

}

function searchBar(input) {
  const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
				console.log(input);
      // let data = JSON.stringify({
        // let input = document.getElementById("input-value").value;
      // });
    let data = this.responseText;
				data = JSON.parse(data);
        console.log(data);
        let tableElement =`
        <div class="row">
        `;
        
        for (let i in data){
          tableElement = tableElement + `
          <div class="col-lg-3 col-md-4 ">
           <div class="card">
                <a class="text-dark">
                
                <img src="${data[i].imageUrl}" class="card-img-top" object-fit:cover;>
                <div class="card-body">
                <span class="card-title" >${data[i].name}</span>
                <h5 class="card-title text-danger">${data[i].price}</h5>
                <button style="all: unset; background-color: steelblue; color: white; padding: 5px, 20px, border-radius: 5px; cursor: pointer;" id="open">상세보기</button>
                
    
                
                </div> </a></div></div>`;
              }
              tableElement = tableElement + `</div>`;
        document.getElementById("all").innerHTML = tableElement;
        
              
      };
      xhttp.open( "GET", "search/searchName/0/8?input=" + input);
      xhttp.send();
}

