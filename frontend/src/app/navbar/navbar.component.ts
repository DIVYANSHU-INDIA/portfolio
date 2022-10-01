import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
// When the user scrolls the page, execute myFunction
onscroll = () => {this.myFunction()};

// Get the navbar
 navbar:any = document.getElementById("navbar");

// Get the offset position of the navbar
 sticky: any = this.navbar?.offsetTop;

// Add the sticky class to the navbar when you reach its scroll position. Remove "sticky" when you leave the scroll position
myFunction() {
  if (window.pageYOffset >= this.sticky) {
    this.navbar?.classList.add("sticky")
  } else {
    this.navbar.classList.remove("sticky");
  }
} 
}
