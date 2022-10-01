import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Article } from '../Model/Article';
import { WishlistService } from '../wishlist.service';

@Component({
  selector: 'app-view-article',
  templateUrl: './view-article.component.html',
  styleUrls: ['./view-article.component.css']
})
export class ViewArticleComponent {
  wishList:Article[]|undefined;
  fav:Article|undefined;
  
  constructor(private service:WishlistService) { 
    const observer={
      next: (result:Article[])=>{
         this.wishList=result;
      },
      error : (error:Error)=>{
        console.log("error is "+error.message);
      },
      complete: ()=>{
        console.log("completed");
      }
    }
    const observable:Observable<Article[]> = service.getWishList();
    observable.subscribe(observer);
    }
 
viewPort(article:any){
this.fav=article;
}

close(){
  this.fav = undefined;
}
}
