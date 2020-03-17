import axios from 'axios'

class ProductService {

    getAllProducts() {
        return axios.get(`http://localhost:8080/products`)

    }
    getProductById(id) {
        return axios.get(`http://localhost:8080/products/${id}`)

    }
    deleteProduct(id) {
        return axios.delete(`http://localhost:8080/products/${id}`)

    }

    updateProductClicked(id, product) {
        return axios.put(`http://localhost:8080/products/${id}`, product)

    }

    getAllCategories() {
        return axios.get(`http://localhost:8080/categories`)

    }

}
export default new ProductService();