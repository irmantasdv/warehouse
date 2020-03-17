import React, { Component } from 'react'
import ProductService from '../../api/ProductService';

class CategoryList extends Component {

    constructor(props) {
        super(props)
        this.state = {
            categories: []
        }
    }
    componentDidMount() {
        ProductService.getAllCategories()
            .then(
                response => {
                    console.log(response.data);
                    this.setState(

                        { categories: response.data }

                    )
                }
            )
    }

    render() {
        return (
            <div className="container">
                <table className="table">
                    <thead>
                        <tr>
                            <th>description</th>
                            <th>name</th>
                        </tr>
                    </thead>
                    <tbody>
                        {this.state.categories.map(
                            category =>
                                <tr key={category.id}>
                                    <td>{category.name}</td>
                                    <td>{category.decription}</td>
                                </tr>

                        )}
                    </tbody>
                </table>

            </div>
        )
    }
}
export default CategoryList;