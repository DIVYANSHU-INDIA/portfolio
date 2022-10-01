import { NgModule, ViewChild } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddArticleComponent } from './add-article/add-article.component';
import { ContentComponent } from './content/content.component';
import { HomeComponent } from './home/home.component';
import { ViewArticleComponent } from './view-article/view-article.component';

const routes: Routes = [
  {
    path:'content', component: ContentComponent
  },
  {
    path:'home', component: HomeComponent
  },
  {
    path:'add', component: AddArticleComponent
  },
  {
    path:'view', component: ViewArticleComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
