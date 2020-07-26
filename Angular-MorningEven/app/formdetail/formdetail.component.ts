import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { FormBuilder, Validators} from "@angular/forms";
import { DatasetService } from '../dataset.service';


@Component({
  selector: 'app-formdetail',
  templateUrl: './formdetail.component.html',
  styleUrls: ['./formdetail.component.scss']
})
export class FormdetailComponent implements OnInit {

  
  constructor(private fb : FormBuilder,private dataset: DatasetService) { }

  userform = this.fb.group({
    Fname : ['',Validators.required],
    Lname : ['',Validators.required],
    age : ['', [Validators.min(1),Validators.max(50)]],
    city : [''],
    Empid : ['',Validators.required]
  });


  @Output()
  Emitevent = new EventEmitter<string>();

  @Output()
  ToggleEvent = new EventEmitter<string>();

  ngOnInit(): void {
  }
  toggleinner()
  {
    console.log("inside toggle");
    this.ToggleEvent.emit("111"); 
  }

  insert(){
    this.userform.reset();
    
    this.userform.get("Empid").enable();
  }
  update(item)
  {
    console.log("update",item);
    this.userform.setValue(item);
    this.userform.get("Empid").disable();
  }
  onSubmit()
  {
    this.userform.get("Empid").enable();
    let key = this.userform.value.Empid;
    console.log(key);
    this.dataset.additem(key,this.userform.value);
    this.Emitevent.emit('load');
    alert("User details added Successfully!");
  }
 

}
