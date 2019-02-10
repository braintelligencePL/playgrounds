import {Component, OnInit} from '@angular/core';
import {Recipe} from '../recipe.model';

@Component({
  selector: 'app-recipe-list',
  templateUrl: './recipe-list.component.html',
  styleUrls: ['./recipe-list.component.css']
})
export class RecipeListComponent implements OnInit {

  recipes: Recipe[] = [
    new Recipe(
      'name1',
      'desc... desc... desc... desc...',
      'https://bit.ly/2Mb8Cl2')
  ];

  constructor() {

  }

  ngOnInit() {
  }

}
