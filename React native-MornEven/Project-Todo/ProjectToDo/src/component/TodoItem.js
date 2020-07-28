import React from 'react';
import {Text, View, TouchableOpacity, StyleSheet, Alert} from 'react-native'
import { removeItem } from './StoreDB'

const TodoItem = (props) =>{

      const selectItem = (index,data)=>{
            Alert.alert(
            'Delete',
            'Are you sure!! you want to delete Todo '+data,
            [
              {text: 'NO', onPress: () => console.log('no pressed'), style: 'cancel'},
              {text: 'YES', onPress: () => delete_item(index)},
            ])
            
      }

      const  delete_item = async (index )=>{
            await removeItem(index);
            props.load();
      }

      return(
            <TouchableOpacity style={style.container} onLongPress={()=>selectItem(props.index_pos,props.data)}>
                  <View style={style.doitem}>
                   <Text style={style.itemtext}>
                        { props.data}
                   </Text>
                   </View>
            </TouchableOpacity>
      );
}

const style = StyleSheet.create({
      doitem:{
            width:"100%",
            paddingVertical:8,
            paddingHorizontal:4
      },
      itemtext:{
            fontSize:15,
            fontWeight:"600",
            marginLeft:20,
            color: "magenta"
      },
      container:{
            width:"96%",
            borderWidth:3,
            borderStyle:"solid",
            borderColor:"black",
            marginHorizontal:"2%",
            marginVertical:5,
            borderRadius:30,

      }
});

export default TodoItem;