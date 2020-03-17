
import React, { Component } from 'react'
import ProductService from '../../api/ProductService'
class ProductList extends Component {

    constructor(props) {
        super(props)
        this.state = {
            products: [],
            message: null
        }

    }
    componentDidMount() {
        this.refreshProductList();
    }


    refreshProductList = () => {
        ProductService.getAllProducts()
            .then(
                response => {
                    this.setState({ products: response.data })
                }
            )
    }


    deleteProductClicked = (id) => {
        console.log(id)
        ProductService.deleteProduct(id)
        .then(response => {
            this.setState(
                { message: `${id} deleted OK.`}
            )
            this.refreshProductList();
        })
        
    }

    updateProductClicked = (id) => {
        console.log(id + " update")
        this.props.history.push(`/product/${id}`)
        // ProductService.updateProductClicked(id);

    }

    render() {
        return (
            <div className="container">
                <table className="table">

                    <thead>
                        <tr>
                            <th>sku</th>
                            <th>name</th>
                            <th>qty</th>
                            <th>Category id</th>
                            <th>Delete</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <tbody>
                        {this.state.products.map(
                            product =>
                                <tr key={product.id}>
                                    <td>{product.sku}</td>
                                    <td>{product.name}</td>
                                    <td>{product.qty}</td>
                                    <td>{product.categoryId}</td>
                                    <td><button className="btn btn-warning" onClick={() => this.deleteProductClicked(product.id)}>Delete</button></td>
                                    <td><button className="btn btn-warning" onClick={() => this.updateProductClicked(product.id)}>Update</button></td>
                                </tr>
                        )}
                    </tbody>
                </table>

            </div>
        )
    }
}
export default ProductList;