from flask import Flask, jsonify
from py_eureka_client import eureka_client

app = Flask(__name__)

# Eureka client setup
eureka_client.init(
    eureka_server="http://eureka-server:8761/eureka",
    app_name="recommendation-service",
    instance_port=5000
)

@app.route('/recommendations/<user_id>', methods=['GET'])
def get_recommendations(user_id):
    # Implement recommendation logic here
    recommendations = ["product1", "product2", "product3"]
    return jsonify({"user_id": user_id, "recommendations": recommendations})

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000)