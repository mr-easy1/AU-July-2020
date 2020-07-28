import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FormdetailComponent } from './formdetail/formdetail.component';

const routes: Routes = [
  { path: 'component1', component: FormdetailComponent },
  { path: 'component2', component: FormdetailComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
