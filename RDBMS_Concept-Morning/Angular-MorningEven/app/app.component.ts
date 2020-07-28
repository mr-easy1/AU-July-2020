import { Component, OnInit, OnChanges, ViewChild } from '@angular/core';
import { DatasetService } from './dataset.service';
import { FormdetailComponent } from "./formdetail/formdetail.component";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})


export class AppComponent implements OnInit{

  title = 'my-project';
  tabledata;
  displayForm:boolean = false;
  constructor(private dataset : DatasetService ){}

  emitdatahandler(str){
    
    this.ngOnInit();
        
    this.toggle();
  }
  @ViewChild(FormdetailComponent) child:FormdetailComponent;
  update(item)
  {
    this.toggle();
    this.child.update(item);
  
  }

  insert()
  {
    this.toggle();
    this.child.insert();
  }

  toggle(str?)
  {
    this.displayForm = ! this.displayForm;
    console.log(this.displayForm);
    // alert("User details updated Successfully!");
  }


  // "Are you sure that you want to delete this record where FirstName="
  delete(str: string,str1: string,str2: string,str3: string,str4:string)
  {
    if(confirm("Are you sure that you want to delete this record where FirstName="+str1+",LastName="+str2+",age="+str3+",City="+str4))
    {
      this.dataset.removeitem(str);
      this.ngOnInit();
    }
    else
    {
      this.ngOnInit();
    }

  }
  ngOnInit()
  {
    this.tabledata = this.dataset.getAllitem();
    console.log(this.tabledata);
  }

  sortTable(n) {
    var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
    table = document.getElementById("myTable");
    switching = true;
    dir = "asc"; 
    while (switching) {
      switching = false;
      rows = table.rows;
      for (i = 1; i < (rows.length - 1); i++) {
        shouldSwitch = false;
        x = rows[i].getElementsByTagName("TD")[n].innerText;
        y = rows[i + 1].getElementsByTagName("TD")[n].innerText;
        if(x-y)
        {
          console.log("integer");
          x = parseInt(x);
          y = parseInt(y);
          if (dir == "asc") {
            if (x > y) {
              shouldSwitch= true;
              break;
            }
          } else if (dir == "desc") {
            if (x < y) {
              shouldSwitch = true;
              break;
            }
          }
  
        }else
        {
          console.log("string");

          if (dir == "asc") {
            if (x.toLowerCase() > y.toLowerCase()) {
              shouldSwitch= true;
              break;
            }
          } else if (dir == "desc") {
            if (x.toLowerCase() < y.toLowerCase()) {
              shouldSwitch = true;
              break;
            }
          }
  
        }
      }
      if (shouldSwitch) {
        rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
        switching = true;
        switchcount ++;      
      } else {
        if (switchcount == 0 && dir == "asc") {
          dir = "desc";
          switching = true;
        }
      }
    }
  }
}
