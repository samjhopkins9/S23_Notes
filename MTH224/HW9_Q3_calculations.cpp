#include <iostream>
#include <cmath>
#include <vector>

using namespace std;

// function takes a vector of doubles as a pass-by referance and returns the same vector sorted in ascending order
vector<double> sort(vector<double>& in1){
    
    // for each value in the vector, compares it to every other value and moves current value up if greater than compared value
    for (double d : in1){
        
        for (double n : in1){
            
            if (d > n){
                
                double t = n;
                n = d;
                d = t;
                
            } // end of if
            
        } // end of for loop
        
    } // end of for loop
    
    return in1;
    
} // end of sort function

// Structure represents Dataset
struct Dataset {
    
    vector<double> data;
    int length;
    double mean;
    double median;
    double q1;
    double q3;
    double var;
    double sd;
    
    // constructor saves sorted dataset and length as attributes calculates and saves average, variance, q1, q3, median and standard deviation
    Dataset(vector<double> indata){
        
        data = sort(indata);
        length = data.size();
        
        // adds all data values, then divides by length to calculate average
        double avg = 0;
        for (double d : data){
            
            avg += d;
            
        } // end of for loop
        
        avg /= length;
        mean = avg;
        
        // adds square of distance from mean for all values of dataset, divides by length to calculate variance
        double variance = 0;
        for (double d : data){
            
            variance += pow((d-avg), 2);
            
        } // end of for loop
        
        variance /= length;
        var = variance;
        // takes square root of variance to calculate standard deviation
        sd = sqrt(variance);
        
        // if length is divisible by 2, median is average of two middle values; otherwise, it is just the middle value
        median = length % 2 == 0 ? (data[length/2-1] + data[length/2])/2 : data[length/2];
        
        // if length is divisible by four, q1 and q3 are averages of the middle two values of the lower and upper halves of the dataset, respectively;
        // if not, q1 and q3 are middle values of their respective halves of the dataset
        q1 = length % 4 == 0 ? (data[length/4-1] + data[length/4])/2 : data[length/4];
        q3 = length % 4 == 0 ? (data[length*3/4-1] + data[length*3/4])/2 : data[length*3/4];
        
    } // end of RV constructor
    
    void report(){
        
        cout << endl;
        cout << "Mean: " << mean << endl;
        cout << "Median: " << median << endl;
        cout << "Q1: " << q1 << endl;
        cout << "Q3: " << q3 << endl;
        cout << "Variance: " << var << endl;
        cout << "SD: " << sd << endl;
        cout << endl;
        
    } // end of report function
    
}; // end of Dataset structure

int main(){
    
    Dataset eye = Dataset({18.0, 18.0, 18.0, 19.0, 22.0, 22.0, 22.5, 22.8, 24.0, 24.0, 25.0, 25.0, 25.0, 25.0, 26.0, 26.4});
    Dataset ruler = Dataset ({18.8, 18.9, 18.9, 19.6, 20.1, 20.4, 20.4, 20.4, 20.5, 20.5, 21.2, 21.4, 22.0, 22.0, 22.0, 23.6});
    Dataset ruler_string = Dataset({20.2, 20.5, 20.5, 20.7, 20.8, 20.9, 21.0, 21.0, 21.0, 21.0, 21.0, 21.3, 21.5, 21.5, 21.5, 21.6});
    Dataset ruler_ball = Dataset ({20.0, 20.0, 20.0, 20.2, 20.2, 20.5, 20.5, 20.5, 20.7, 20.7, 21.0, 21.3, 21.5, 21.6, 22.1, 22.3});
    
    eye.report();
    ruler.report();
    ruler_string.report();
    ruler_ball.report();
    
} // end of main function
