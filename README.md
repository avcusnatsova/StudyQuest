# TerrainIQ

> A geospatial landslide risk analysis system built with Python, OpenCV, Scikit-learn, and GeoPandas to estimate environmental risk using soil imagery, terrain slope, and rainfall data.

## Overview

**TerrainIQ** is a geospatial risk analysis system designed to estimate landslide risk by combining **computer vision, machine learning, and geographic data processing**.

The system analyzes soil images using **K-Means clustering** to identify visually distinct soil regions and estimate exposed-soil characteristics. It then combines these results with environmental factors such as **terrain slope and 72-hour rainfall** obtained from GeoJSON data.

These factors are incorporated into a risk-scoring system that produces a normalized landslide risk score and classifies geographic regions as **Low, Medium, or High Risk**.

The project demonstrates the practical integration of **Computer Vision, Unsupervised Machine Learning, and Geospatial Data Processing** into an environmental risk analysis pipeline.

## Key Features

### Soil Image Analysis

* Process soil images using OpenCV
* Apply K-Means clustering for image segmentation
* Identify visually distinct soil regions
* Estimate exposed-soil fraction
* Analyze soil characteristics for risk estimation

### Environmental Risk Analysis

TerrainIQ combines multiple environmental factors:

* Soil characteristics
* Exposed soil fraction
* Terrain slope
* 72-hour accumulated rainfall

These factors are combined to calculate a normalized landslide risk score.

### Risk Classification

The calculated risk score is mapped to three categories:

```text
Low Risk
Medium Risk
High Risk
```

### Geospatial Processing

* Process geographic data using GeoPandas
* Read environmental attributes from GeoJSON
* Analyze geographic polygons
* Enrich geographic features with calculated risk information
* Generate a risk-enriched GeoJSON output

### Visual Soil Segmentation

The system generates a segmented soil image that provides a visual representation of the regions identified through K-Means clustering.

## Tech Stack

**Programming Language**

* Python

**Computer Vision**

* OpenCV

**Machine Learning**

* Scikit-learn
* K-Means Clustering

**Numerical Processing**

* NumPy

**Geospatial Processing**

* GeoPandas
* GeoJSON

**Visualization**

* Matplotlib

## System Architecture

```text
                    ┌─────────────────────┐
                    │     Soil Image      │
                    └──────────┬──────────┘
                               │
                               ▼
                    ┌─────────────────────┐
                    │ Image Preprocessing │
                    └──────────┬──────────┘
                               │
                               ▼
                    ┌─────────────────────┐
                    │  K-Means Clustering │
                    └──────────┬──────────┘
                               │
                               ▼
                    ┌─────────────────────┐
                    │ Soil Segmentation   │
                    └──────────┬──────────┘
                               │
                               ▼
                    ┌─────────────────────┐
                    │ Soil Characteristics│
                    │ & Exposed Fraction  │
                    └──────────┬──────────┘
                               │
                               │
              ┌────────────────┴────────────────┐
              │                                 │
              ▼                                 ▼
       Terrain Slope                      Rainfall Data
              │                                 │
              └────────────────┬────────────────┘
                               │
                               ▼
                    ┌─────────────────────┐
                    │   Risk Calculation  │
                    └──────────┬──────────┘
                               │
                               ▼
                    ┌─────────────────────┐
                    │ Risk Classification │
                    └──────────┬──────────┘
                               │
                    ┌──────────┼──────────┐
                    ▼          ▼          ▼
                   Low       Medium      High
                               │
                               ▼
                    ┌─────────────────────┐
                    │   GeoJSON Output    │
                    └─────────────────────┘
```

## Core Workflow

```text
Input Soil Image
        ↓
Image Preprocessing
        ↓
K-Means Clustering
        ↓
Soil Image Segmentation
        ↓
Estimate Soil Characteristics
        ↓
Calculate Exposed Soil Fraction
        ↓
Read Slope + Rainfall from GeoJSON
        ↓
Calculate Risk Score
        ↓
Classify Risk Level
        ↓
Generate Risk-Enriched GeoJSON
```

## Risk Analysis

TerrainIQ calculates landslide risk using multiple environmental characteristics.

### Soil Fragility

Soil characteristics are estimated from the segmented soil image and used as one of the factors contributing to the overall risk.

### Exposed Soil Fraction

The segmented image is used to estimate the proportion of exposed soil within the analyzed image.

### Terrain Slope

Slope is represented in degrees and contributes to the likelihood of landslide formation.

### Rainfall

The system considers accumulated rainfall over a **72-hour period** as an environmental risk factor.

These factors are combined to generate a normalized risk score.

```text
Soil Characteristics
        +
Exposed Soil Fraction
        +
Terrain Slope
        +
72-Hour Rainfall
        ↓
   Risk Score
        ↓
Risk Classification
```

## Input Data

TerrainIQ works with two primary inputs.

### Soil Image

A soil image is processed using K-Means clustering to identify visually distinct regions.

Example:

```text
soil_sample.png
```

The resulting segmentation is saved as:

```text
segmented_output.png
```

### GeoJSON Data

The GeoJSON dataset contains geographic polygons and environmental attributes such as slope and rainfall.

Example:

```json
{
  "type": "Feature",
  "properties": {
    "slope": 28.5,
    "rainfall": 180.0
  },
  "geometry": {
    "type": "Polygon",
    "coordinates": []
  }
}
```

## Output

### Segmented Soil Image

```text
segmented_output.png
```

A visual representation of the soil regions identified through K-Means clustering.

### Risk-Enriched GeoJSON

```text
landslide_risk.geojson
```

The geographic features are enriched with calculated risk information.

Example:

```json
{
  "risk_score": 0.641,
  "risk_level": "Medium"
}
```

## Example Result

```text
--- Landslide Risk Prediction ---

Soil Type: Clay
Slope: 30.0°
Rainfall (72h): 200.0 mm
Exposed Soil Fraction: 0.462

Risk Score: 0.641
Risk Level: Medium
```

## Project Structure

```text
TerrainIQ/
│
├── main.py
├── requirements.txt
├── README.md
│
├── soil_sample.png
├── landslide_data.geojson
└── segmented_output.png
```

### File Overview

| File                     | Description                                                           |
| ------------------------ | --------------------------------------------------------------------- |
| `main.py`                | Main soil analysis, risk calculation, and GeoJSON processing pipeline |
| `requirements.txt`       | Python dependencies                                                   |
| `soil_sample.png`        | Sample soil image used for analysis                                   |
| `landslide_data.geojson` | Geographic data containing environmental attributes                   |
| `segmented_output.png`   | Generated K-Means soil segmentation result                            |

## Getting Started

### Prerequisites

Make sure the following are installed:

* Python 3.x
* pip
* Git

### 1. Clone the Repository

```bash
git clone <YOUR-REPOSITORY-URL>
cd TerrainIQ
```

### 2. Install Dependencies

```bash
pip install -r requirements.txt
```

### 3. Prepare Input Data

Add the required:

* Soil image
* GeoJSON dataset containing environmental attributes

to the project directory.

### 4. Run the Application

```bash
python main.py
```

### 5. Review the Output

After execution, review:

```text
segmented_output.png
landslide_risk.geojson
```

for the soil segmentation and calculated geographic risk information.

## Technical Concepts

TerrainIQ demonstrates practical application of:

* Computer Vision
* Unsupervised Machine Learning
* K-Means Clustering
* Image Segmentation
* Soil Analysis
* Geospatial Data Processing
* GeoJSON Processing
* Environmental Data Analysis
* Risk Scoring
* Data Visualization
* Python Data Pipelines

## What I Learned

Building TerrainIQ provided practical experience in combining **image processing, machine learning, and geographic data** within a single analytical pipeline.

The project helped me understand:

* Image preprocessing and segmentation
* K-Means clustering for unsupervised analysis
* Processing environmental datasets
* Working with GeoJSON geographic data
* Combining multiple environmental factors into a risk score
* Generating machine-readable geospatial outputs
* Designing a Python-based data processing pipeline

## Future Improvements

Potential future enhancements include:

* CNN-based automated soil classification
* Deep learning-based soil image analysis
* Interactive geospatial risk heatmaps
* Real-time rainfall and weather data integration
* Web-based visualization dashboard
* Satellite imagery integration
* Historical landslide datasets for supervised model training

## Author

**Cusnat Sova**

B.E. Computer Science Engineering
Panimalar Engineering College

### Project Focus

`Python` · `OpenCV` · `Scikit-learn` · `K-Means` · `GeoPandas` · `GeoJSON` · `NumPy` · `Matplotlib`
