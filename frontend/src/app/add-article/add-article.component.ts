import { getLocaleDateFormat } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { Observable } from 'rxjs';
import { Article } from '../Model/Article';
import { WishlistService } from '../wishlist.service';

@Component({
  selector: 'app-add-article',
  templateUrl: './add-article.component.html',
  styleUrls: ['./add-article.component.css']
})
export class AddArticleComponent implements OnInit {
  article:Article|undefined;
  myform: FormGroup;
  date = new Date();
  nameCtrl: FormControl;
  headingCtrl: FormControl;
  contentCtrl: FormControl;
  constructor(builder: FormBuilder, private service:WishlistService) {
    this.nameCtrl = builder.control('');
    this.headingCtrl = builder.control('');
    this.contentCtrl = builder.control('');
    const mapping = {
      authName: this.nameCtrl,
      heading: this.headingCtrl,
      content: this.contentCtrl
    };
    this.myform = builder.group(mapping);
  }
  addArticle() {
    const name=this.nameCtrl.value;
    const heading=this.headingCtrl.value;
    const content= this.contentCtrl.value;
    const currdate = this.date.toDateString();
    
   
    const observer={
      next:(result:any)=>{
        alert("Successfully added the article");
      
      },
      error:(error:Error)=>{
        alert("Couldn't register "+error.message);
      }

    }
    const observable:Observable<any>=this.service.addCityToWishList(name,heading,content,currdate);
    observable.subscribe(observer);
    
  }
  ngOnInit(): void {
  }

}
