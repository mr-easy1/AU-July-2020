import  React,{ useState, useEffect }  from "react";
import { Text, View ,TextInput, Button, StyleSheet } from "react-native";
import {getValue, setUserName} from "./StoreDB"

const Login = ({navigation}) =>{
      const [email, setEmail] = useState("");

     
      useEffect(  ()=>{
            username_exists();
       },[]);
 
     
      const username_exists = async ()=>{
            const username = await getValue("username"); 
            if(username)
            {
                  navigation.navigate('Todo');
            }
      }

      const login =()=>
      {
            if(email)
            {

                  setUserName(key = "username", email);
                  navigation.navigate('Todo');      
            }else
            {
                  alert("Please insert email id!");
            }      
      }

      return (
            <View style={{ flex: 1, alignItems: 'center', justifyContent: 'center' }}>
            <Text style={style.title}>To do gives you focus</Text>
            <Text style={style.title}>From work to play</Text>
            <Text style={style.title}>Lets To do!</Text>
            <Text style={style.label}>Please enter your email id</Text>
            <TextInput style={style.textbox} onChangeText={(text)=>{ setEmail(text)} } placeholder="umar.aalam@example.com"></TextInput>
            <Button style={style.submit} onPress={login}  title="Login" ></Button>
          </View>
      );
};

const style = StyleSheet.create({
      title:{
            fontSize:40,
            fontWeight:"700",
            color:"blue"
      },
      label:{
            fontSize:12,
            marginTop:20,
            fontWeight:"400",
            color:"#000"},
      textbox:{
            fontSize:15,
            padding:5,
            borderColor:"#777",
            borderWidth:2,
            borderRadius:8,
            margin:15,
            width:"70%",
            textAlign:"center"
            
      },
      submit:{
            borderRadius:30,
            height:60,
            width:"50%"
      },
      a:{
            color:"blue"
      }
});


export default Login;