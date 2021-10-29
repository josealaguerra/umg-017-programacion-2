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
	this.state = {
		resultText: ""
	}
  }
  
  
  calculateResult(  ){
	const text = this.state.resultText
	//now parse this text
  }
  
  
  buttonPressed (text) {
	console.log(text)
	
	if(text == '='){
		return this.calculateResult()
	}

	this.setState({
		resultText: this.state.resultText + text
	})
  }
  
  operate(operation){
	switch(operation ){
		case 'D':
			let text = this.state.resultText.split('')
			text.pop()
			text.join()
			this.setState({
				resultText:text
			})
		
		
	}
  }
  
  
  

 render() {
	 
	 let rows = []
	 let nums = [[1, 2, 3], [4, 5, 6], [7, 8, 9], ['.', 0, '=']]	 
	 for(let x=0; x<4; x++){
		let row = []
		for(let y=0; y<3; y++){
			row.push(	<TouchableOpacity onPress={() => this.buttonPressed(nums[x][y])} style={styles.btn}>
							<Text style={styles.btnText}>
								{nums[x][y]}
							</Text>
						</TouchableOpacity> )
		}			 
		rows.push(<View style={styles.row}>{row}</View>)
	 }

	 let operations = ['D', '+', '-', '*', '/']
	 let ops = []
	 for(let k=0; k<4; k++){
		ops.push(	<TouchableOpacity style={styles.btn} onPress={() => this.operate( operations[i] )} >
						<Text style={[styles.btnText, styles.white]}>
							{operations[k]}
						</Text>
					</TouchableOpacity> )
	 }


	 
	 
    return (
      <View style={styles.container}>
        <View style={styles.result}>
			<Text style={styles.resultText}>{this.state.resultText}</Text>
		</View>
        <View style={styles.calculation}>
			<Text style={styles.calculationText}>144</Text>
		</View>
		<View style={styles.buttons}>
			<View style={styles.numbers}>
				{rows}
			</View>
			<View style={styles.operations}>
				{ops}
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
  btnText: {
    fontSize: 25
  },
  white: {
    color: 'white'
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
