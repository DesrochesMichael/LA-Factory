import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'lafactory';
  public terme: String = null;
  constructor(private router: Router) { }
  public recherche(): void {
    this.router.navigate(['/recherche', this.terme]);
  }
}
