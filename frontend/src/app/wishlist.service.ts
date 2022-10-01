import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Article } from './Model/Article';

@Injectable({
  providedIn: 'root'
})
export class WishlistService {

  constructor(private client:HttpClient ) { }
  addCityToWishList(name:string,heading:string,content:string,date:string):Observable<Article>{
    const url="http://localhost:8585/wishlist/add"; 
    const requestData: Article = {
      authorName: ""+name,
    articleHeading: ""+heading,
    articleContent: "" +content,
    date: "" + date,
    
    }
    const observable:Observable<Article>=this.client.post<Article>(url,requestData);
    return observable;
  }

  getWishList():Observable<Article[]>{
    const url="http://localhost:8585/wishlist/list";
    const observable:Observable<Article[]>=this.client.get<Article[]>(url);
    return observable;
  }
}
