import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { GestionarComicComponent } from './semillero/componentes/gestionarComic/gestionar-comic';
import { BienvenidaComponent } from './semillero/componentes/home/bienvenida-component';
import { ConsultarComicComponent } from './semillero/componentes/gestionarComic/consultarComic/consultar-comic';
import { GestionarProveedorComponent } from './semillero/componentes/gestionarProveedor/gestionar-proveedor';
import { ConsultarProveedorComponent } from './semillero/componentes/gestionarProveedor/consultarProveedor/consultar-proveedor';

const routes: Routes = [
  { path: 'gestionar-comic', component: GestionarComicComponent },
  { path: 'consultar-Comic', component: ConsultarComicComponent},
  { path: 'consultar-proveedor', component: ConsultarProveedorComponent},
  { path: 'gestionar-proveedor', component: GestionarProveedorComponent},
  { path: 'bienvenida', component: BienvenidaComponent, data : null }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
