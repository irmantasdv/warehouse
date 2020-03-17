import React, { Component } from 'react'
import { Formik, Form, Field, ErrorMessage } from 'formic';
import ProductService from '../../api/ProductService'
class Product extends Component {

    constructor(props) {
        super(props)
        this.state = {
            id: this.props.match.params.id,
            name: '',
            qty: ''
        }
    }
    componentDidMount() {
        ProductService.getProductById(this.state.id)
            .then(response =>
                this.setState(
                    {
                        name: response.data.name,
                        qty: response.data.qty

                    }
                ))
    }
    render() {
        return (
            <div className="container">
                <h1>Product Component</h1>
                <div>Product Component : {this.props.match.params.id}</div>
                <p>Name: {this.state.name}</p>
                <p>qty: {this.state.qty}</p>
            </div>
        )
    }

}
export default Product;