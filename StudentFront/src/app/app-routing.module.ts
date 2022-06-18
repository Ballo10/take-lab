import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { StudentsComponent } from './students/students.component';
import { StudentDetailComponent } from './student-detail/student-detail.component';
import { AboutComponentComponent } from './about-component/about-component.component';

const routes: Routes = [{ path: 'about', component: AboutComponentComponent },
{ path: 'students', component: StudentsComponent },
{ path: '', redirectTo: '/students', pathMatch: 'full' },
{ path: 'detail/:id', component: StudentDetailComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
