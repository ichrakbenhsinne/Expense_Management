import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { HomeComponent } from './pages/home/home.component';
import { TestComponent } from './pages/test/test.component';
import { ErreurComponent } from './pages/erreur/erreur.component';
import { LogoutComponent } from './pages/logout/logout.component';
import { InscriptionComponent } from './pages/inscription/inscription.component';
import { UserinterfaceComponent } from './pages/userinterface/userinterface.component';
import { DepenceComponent } from './pages/depence/depence.component';
import { SidebarComponent } from './pages/sidebar/sidebar.component';
import { PiechartComponent } from './pages/stat/piechart/piechart.component';



const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
{ path:'login', component:LoginComponent},
{path:'home',component:HomeComponent},
{path:'test',component:TestComponent},
{path:'err',component:ErreurComponent},
{path:'logout',component:LogoutComponent},
{path:'inscrit',component:InscriptionComponent},
{path:'user',component:UserinterfaceComponent},
{path:'dep',component:DepenceComponent},
{path:'sidebar',component:SidebarComponent},
{ path: 'stat', component: PiechartComponent },


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
