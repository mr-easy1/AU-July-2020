import  React, { useState, useEffect }  from "react";
import { Text, View, StyleSheet, FlatList, TouchableOpacity } from "react-native";
import { getValue, getItemFromDB, removeUserName } from "./StoreDB";
import TodoItem from "./TodoItem";
import TodoAddItem from "./TodoAddItem";

const Todo = ({navigation}) =>{

      const [email, setEmail] = useState("");
      const [items, setItems] = useState([]);

      
      useEffect( ()=>{
           username_exists();
           loadItems();
           navigation.setOptions({
            headerRight : ()=>(
              <TouchableOpacity style={style.logout} onPress={()=>Logout()}>
                <Text>Logout</Text>
              </TouchableOpacity>
            )
          });
      },[]);

      const loadItems = async ()=>{
            let data = await getItemFromDB();
            setItems(data);
      }

      const display_items = ()=>{
            if (items && items.length > 0)
            {
                  return (<FlatList
                  style={{width:"100%"}}
                  data={items}
                  renderItem={({item, index})=><TodoItem data={item} index_pos={index}  load={loadItems} />}
                  keyExtractor={(item,index)=>index+""}
                  />);
            }else {
                  return (<View style={{flex:1}}>
                          <Text style={style.stxt}>Add something to Todo</Text>
                        </View>)
            }
      }
      
      const username_exists = async ()=>{
            const username = await getValue("username");
            if(username)
            {
                  console.log(username)
                 setEmail(username);
            }else{
                  navigation.navigate('Login');
            }
      }

      const  Logout = () =>
      {
            try {      
                  console.log("logout");
                  removeUserName("username");
                  navigation.navigate('Login');
                  
            } catch (error) {
                  
            }        
      }
      return (
            <View style={{ flex: 1, alignItems: 'center', justifyContent: 'flex-start' }}>
            {display_items()}
            <TodoAddItem load={loadItems}></TodoAddItem>
            <Text>Welcome! {email}</Text>
            
          </View>
      );
};

const style = StyleSheet.create({
      addbutton:{
            height:70,
            width:70,
            position:"absolute",
            bottom:60,
            right:30
      },
      addimage:{
            height:"100%",
            width:"100%",
            borderRadius:100,
      },
      logout:{
        marginTop:10,
        marginRight:15,
        backgroundColor:"red",
        padding:10,
        borderRadius:10
      },
      stxt:{
            color: "orange",
            marginTop:20,
            fontSize:30

      }
    }); 

export default Todo;