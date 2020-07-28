import React, {useState} from 'react';
import {TextInput, View, StyleSheet,TouchableOpacity,Image} from 'react-native'
import { addItemInDB } from "./StoreDB";

const TodoAddItem = (props) =>{

      const [item, setItem] = useState("");

      const AddItem=async ()=>{
            if(item)
            {
                  await addItemInDB(item);
                  alert(item+"\nAdded Successfully!!");
                  props.load();
                  setItem("");
            }else
                  alert("Please, insert Todo.");            
      }
      return(
            <View style={style.container}>
                   <TextInput style={style.itemtext} onChangeText={(text) => setItem(text)} value={item} placeholder="Enter Todo">                       
                   </TextInput>
                   <TouchableOpacity style={style.addbutton} onPress={()=>AddItem()}>
                        <Image source={require('./../../assets/plus-symbol.png')}  style={style.addimage} ></Image>
                   </TouchableOpacity>
            </View>
      );
}

const style = StyleSheet.create({
      
      itemtext:{
            fontSize:15,
            color:"#666",
            fontWeight:"600",
            marginVertical:8,
            marginLeft:20,
            flex:1
      },
      btn:{
            borderRadius:30
      },
      container:{
            width:"95%",
            borderWidth:0.5,
            borderStyle:"solid",
            borderColor:"#00c",
            marginHorizontal:2,
            marginVertical:5,
            borderRadius:30,
            padding:0,
            flexDirection:"row"
      },addbutton:{
            height:45,
            width:45
      },
      addimage:{
            height:"100%",
            width:"100%",
            borderRadius:100,
      },
});

export default TodoAddItem;