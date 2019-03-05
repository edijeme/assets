import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavigationComponent } from './components/navigation/navigation.component';
import { AsstesFormComponent } from './components/asstes-form/asstes-form.component';
import { AsstesListComponent } from './components/asstes-list/asstes-list.component';

import { AsstesService } from './service/asstes.service';

@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    AsstesFormComponent,
    AsstesListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [AsstesService],
  bootstrap: [AppComponent]
})
export class AppModule { }
