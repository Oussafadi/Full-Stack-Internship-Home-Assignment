import axios from "axios"

export const csvParserApi = axios.create(
    {
        baseURL: "http://localhost:8080"
    }
)

export const saveCSV = (formData) => {
    csvParserApi.post('/process-csv' ,formData , {
        headers : {
            "content-type" : "multipart/form-data"
        }
    }) ;
}