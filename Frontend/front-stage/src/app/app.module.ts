import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PagesComponent } from './pages/pages.component';
import { LayoutComponent } from './layout/layout.component';
import { LoginComponent } from './pages/login/login.component';
import { HomeComponent } from './pages/home/home.component';
import { NavbarComponent } from './layout/navbar/navbar.component';
import { Router, RouterModule } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { TestComponent } from './pages/test/test.component';
import { AuthService } from './auth.service';
import { HttpClientModule } from '@angular/common/http';
import { FooterComponent } from './layout/footer/footer.component';
import { EndsessionComponent } from './pages/endsession/endsession.component';
import { ErreurComponent } from './pages/erreur/erreur.component';
import { NotfoundComponent } from './pages/notfound/notfound.component';
import { LogoutComponent } from './pages/logout/logout.component';
import { InscriptionComponent } from './pages/inscription/inscription.component';
import { DepenceComponent } from './pages/depence/depence.component';
import { BsDatepickerModule } from 'ngx-bootstrap/datepicker';
import { IntermStatComponent } from './pages/interm-stat/interm-stat.component';
import { SidebarComponent } from './pages/sidebar/sidebar.component';
import { UserinterfaceComponent } from './pages/userinterface/userinterface.component';
import { ReportsComponent } from './pages/report/report.component';
import { StatComponent } from './pages/stat/stat.component';
import { PiechartComponent } from './pages/stat/piechart/piechart.component'; // Ajoutez ceci
@NgModule({
  declarations: [
    AppComponent,
    PagesComponent,
    LayoutComponent,
    LoginComponent,
    HomeComponent,
    NavbarComponent,
    TestComponent,
    FooterComponent,
    EndsessionComponent,
    ErreurComponent,
    NotfoundComponent,
    LogoutComponent,
    InscriptionComponent,
    DepenceComponent,
    IntermStatComponent,
    SidebarComponent,
    
    
    UserinterfaceComponent,
         ReportsComponent,
         StatComponent,
         PiechartComponent, // Ajoutez ceci
  ],
  imports: [
    BrowserModule,
    BsDatepickerModule.forRoot(),
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NgChartsModule,
    ReactiveFormsModule,
    RouterModule.forRoot([
      { path: 'login', component: LoginComponent },
      { path: 'home', component: HomeComponent },
      { path: 'test', component: TestComponent },
      { path: 'err', component: ErreurComponent },
      { path: 'logout', component: LogoutComponent },
      { path: 'inscrit', component: InscriptionComponent },
      { path: 'dep', component: DepenceComponent },
      { path: 'sidebar', component: SidebarComponent },
      { path: 'stat', component: PiechartComponent },
    ]),
  ],
  providers: [AuthService, Router],
  bootstrap: [AppComponent],
})
export class AppModule {}
