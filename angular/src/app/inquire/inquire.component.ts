import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import {
  FormArray,
  FormControl,
  FormGroup,
  Validator,
  Validators,
} from '@angular/forms';
@Component({
  selector: 'app-inquire',
  templateUrl: './inquire.component.html',
  styleUrls: ['./inquire.component.css'],
})
export class InquireComponent {
  numberOfPeople: number = 0;
  Math = Math;
  today?: string;

  ngOnInit() {
    const now = new Date();
    const year = now.getFullYear();
    const month = now.getMonth() + 1;
    const day = now.getDate();
    this.today = `${year}-${month.toString().padStart(2, '0')}-${day
      .toString()
      .padStart(2, '0')}`;
  }
  onSubmit() {
    // handle form submission
  }
  getArray() {
    return Array.from(
      { length: Math.max(0, this.numberOfPeople - 1) },
      (_, i) => i
    );
  }
}
