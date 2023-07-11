import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserComponent } from './user/user.component';
import { AdminComponent } from './admin/admin.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { InquireComponent } from './inquire/inquire.component';
import { BannerComponent } from './banner/banner.component';
import { FooterComponent } from './footer/footer.component';
const routes: Routes = [
  { path: 'user', component: UserComponent },
  { path: 'admin', component: AdminComponent },
  { path: 'inquire', component: InquireComponent },
  // { path: '', redirectTo: '/inquire', pathMatch: 'full' },
  { path: '**', redirectTo: '/user' },
];

console.log(routes);

@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    AdminComponent,
    AppComponent,
    InquireComponent,
    BannerComponent,
    FooterComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
  exports: [RouterModule],
})
export class AppModule {}
