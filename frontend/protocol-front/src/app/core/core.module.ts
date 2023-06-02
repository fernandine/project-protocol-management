import { NgModule, Optional, SkipSelf } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AuthService } from '../services/auth.service';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [],
  providers: [AuthService],
  imports: [
    CommonModule,
    HttpClientModule
  ]
})
export class CoreModule {
  constructor(@Optional() @SkipSelf() core:CoreModule ){
    if (core) {
        throw new Error("Core module should only be imported to the Root Module")
    }
  }
}

