import React, { Component } from 'react'
import {
  StyleSheet,
  TouchableOpacity,
  Text,
  View,
  Button,
} from 'react-native'



export default class App extends Component {

  constructor () {
	super()
	this.state = {}
  }

 render() {
    return (
      <View style={styles.container}>
        <View style={styles.result}>
			<Text style={styles.resultText}>12*12</Text>
		</View>
        <View style={styles.calculation}>
			<Text style={styles.calculationText}>12*12</Text>
		</View>
		<View style={styles.buttons}>
			<View style={styles.numbers}>
				<View style={styles.row}>
					<Button title="0" />
					<Button title="0" />
					<Button title="0" />
				</View>
				<View style={styles.row}>
					<Button title="0" />
					<Button title="0" />
					<Button title="0" />
				</View>
				<View style={styles.row}>
					<Button title="0" />
					<Button title="0" />
					<Button title="0" />
				</View>
				<View style={styles.row}>
					<Button title="0" />
					<Button title="0" />
					<Button title="0" />
				</View>
			</View>
			<View style={styles.operations}>
					<Button title="+" />
					<Button title="-" />
					<Button title="*" />
					<Button title="/" />
			</View>
		</View>
      </View>
    )
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1
  },
  btn: {
    flex: 1,
    alignItems: 'center',
    alignSelf: 'stretch',
	justifyContent: 'center'
  },
  resultText: {
    fontSize: 30,
    color: 'white'
  },  
  calculationText: {
    fontSize: 24,
    color: 'white'
  },  
  row: {
    flexDirection: 'row',
    flex: 1,
    justifyContent: 'space-around',
	alignItems: 'center',
	alignItems: 'stretch'	
  },
  result: {
    flex: 2,
    backgroundColor: 'red'
  },  
  calculation: {
    flex: 1,
    backgroundColor: 'green',
	justifyContent: 'center',
	alignItems: 'flex-end'
  },
  buttons: {
	flex: 7,
    flexDirection: 'row'
  },
  numbers: {
    flex: 3,	  
    backgroundColor: 'yellow'
  },
  operations: {
    backgroundColor: 'black',
	flex: 1,
	justifyContent: 'space-around',
	alignItems: 'stretch'
  },  

})




<Button title="0" />
<TouchableOpacity style={styles.btn}><Text>0</Text></TouchableOpacity>