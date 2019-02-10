import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `
  <app-expandable-table></app-expandable-table>
  `,
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'table-with-expandable-rows-angular-materials-rxjs';
}
