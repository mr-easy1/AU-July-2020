import React from 'react';
import {Text, ImageBackground, TouchableOpacity, StyleSheet} from 'react-native'

const Card = (props) =>{

      return(
            <TouchableOpacity style={styles.container}>
                  <ImageBackground style={styles.background} source={
                        {uri: props.data.urlToImage  }} imageStyle={{borderRadius: 30}}>
                        <Text style={styles.source}>{props.data.source.name}</Text>
                  <Text style={styles.title}>{props.data.title}</Text>
                  </ImageBackground>
            </TouchableOpacity>
      );
}

const styles = StyleSheet.create({
      title:{
            fontSize:15,
            color:"cyan",
            padding:5
      },
      source:{
            alignSelf:"flex-end",
            fontSize:20,
            color:"cyan",
            fontWeight:"400",
            padding:5
      },
      background:{
            backgroundColor:"black",
            
            height:"100%",
            width:"100%",
            borderRadius:30,
            justifyContent:"space-between"
      },
      container:{
            width:"95%",
            height:150,
            marginLeft:"2.5%",
            marginRight:"2.5%",
            marginVertical:5,
            borderRadius:30,

      }
});

export default Card;